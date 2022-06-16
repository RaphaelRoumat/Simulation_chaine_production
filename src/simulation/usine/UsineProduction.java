package simulation.usine;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import simulation.materiau.Materiau;
import simulation.materiau.StockMateriau;

import simulation.reseau.Reseau;
import simulation.reseau.Transition;

public class UsineProduction implements Usine, Observer {
    private int id;
    private String nom;
    private int[] coords = new int[2];
    private List<Image> icones;
    private int current_icone = 0;
    private int interval_production;
    private double production_speed = 1;
    private double depuis_production = 1.d;
    private HashMap<Materiau, StockMateriau> entrees;
    private Materiau sortie;

    private Usine destination = null;
    private Reseau reseau;

    public UsineProduction(int id, String nom, int[] coords, List<String> icones_path,
            HashMap<Materiau, StockMateriau> entrees, Materiau sortie, int interval_production, Reseau reseau) {
        this.id = id;
        this.nom = nom;
        this.coords = coords;
        this.entrees = entrees;
        this.sortie = sortie;
        this.interval_production = interval_production;
        this.reseau = reseau;

        this.icones = new ArrayList<Image>();

        for (String path : icones_path) {
            Image image = null;
            try {
                image = ImageIO.read(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.icones.add(image);
        }
    }

    public int[] getCoords() {
        return coords;
    }

    public boolean peuRecevoir(Materiau mat) {

        StockMateriau stock = entrees.get(mat);
        if (stock == null) // Le stock pour ce materiau n'existe pas
        {
            return false;
        } else if (stock.is_fullyReserved()) // Le stock existe mais est plein
        {
            return false;
        } else
            return true; // Le stock pour ce materiau existe et n'est plein
    }

    public void recevoirMateriau(Materiau mat) {
        entrees.get(mat).add_Materiau(mat);
    }

    public boolean peuProduire() {
        var it = entrees.entrySet().iterator();

        while (it.hasNext()) {
            var pair = it.next();

            if (!pair.getValue().is_full()) {
                return false;
            }

        }
        return true;
    }

    private void produire() {
        Materiau mat = new Materiau(sortie.getNom());
        Transition transition = new Transition(this, destination, mat);
        reseau.ajouterTransition(transition);
        depuis_production = 0;

        var it = entrees.entrySet().iterator();
        while (it.hasNext()) {
            var pair = it.next();

            pair.getValue().clear();
        }

    }

    public Image getIcone() {
        return icones.get(current_icone);
    }

    public void drawUsine(Graphics g) {
        int[] coord_usine = this.getCoords();
        Image image = this.getIcone();
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        g.drawImage(this.getIcone(), coord_usine[0] - width / 2, coord_usine[1] - height / 2, null);

    }

    @Override
    public void update(Observable observable, Object arg) {

        Entrepot entrepot = (Entrepot) observable;
        double remplissage_entrepot = entrepot.pourcent_remplissage();

        if (remplissage_entrepot < 0.5) {
            production_speed = 1.d;
        } else if (remplissage_entrepot >= 0.5) {
            production_speed = 0.7;
        } else if (remplissage_entrepot >= 0.75) {
            production_speed = 0.3;
        }
    }

    @Override
    public void setDestination(Usine usine) {
        destination = usine;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void stepUsine() {

        if (peuProduire()) {

            if (depuis_production >= interval_production && destination.peuRecevoir(sortie)) {
                produire();
            }

            depuis_production += 1 * production_speed;
        }

        // mise à jour de l'icone actuel

        int interval_step = interval_production / icones.size();
        for (int i = 1; i <= icones.size(); i++) {
            if (i * interval_step > depuis_production) {
                current_icone = i - 1;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("UsineProd: " + "id=" + id + ", nom=" + nom + ", interval=" + interval_production + ", dest="
                + destination.getId() + "\n");
        str.append(" entrées:\n" + entrees.toString() + "\n");
        str.append(" sortie :\n" + sortie.toString());

        return str.toString();
    }

    public void reserver(Materiau mat) {
        StockMateriau stock = entrees.get(mat);
        stock.reserver();
    }

}
