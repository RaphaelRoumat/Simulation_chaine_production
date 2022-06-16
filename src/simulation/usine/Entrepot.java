package simulation.usine;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.imageio.ImageIO;

import simulation.materiau.Materiau;
import simulation.materiau.StockMateriau;
import simulation.reseau.Reseau;

public class Entrepot extends Observable implements Usine {
    private int id;
    private String nom;
    private int[] coords;
    private List<Image> icones;
    private int current_icone;

    // TODO implémenter le package stratégie
    private StockMateriau stock;
    // private StrategieVente strategieVente;

    public Entrepot(int id, String nom, int[] coords, List<String> icones_path, StockMateriau stock) {
        this.id = id;
        this.nom = nom;
        this.coords = coords;
        this.icones = new ArrayList<Image>();
        this.stock = stock;

        for (String path : icones_path) {
            Image image = null;
            try {
                image = ImageIO.read(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (image == null)
                System.out.println("FAIL LOAD: " + path);
            this.icones.add(image);
        }
    }

    public int[] getCoords() {
        return coords;
    }

    public boolean peuRecevoir(Materiau mat) {

        if (stock.getTypeMateriau().equals(mat.getNom())) {
            if (stock == null) // Le stock pour ce materiau n'existe pas
            {
                return false;
            } else if (stock.is_fullyReserved()) // Le stock existe mais est plein
            {
                return false;
            } else
                return true; // Le stock pour ce materiau existe et n'est pas plein
        } else
            return false;

    }

    @Override
    public void recevoirMateriau(Materiau mat) {
        stock.add_Materiau(mat);
        notifyObservers(new Object());
    }

    public Image getIcone() {
        return icones.get(current_icone);
    }

    @Override
    public void drawUsine(Graphics g) {
        int[] coord_usine = this.getCoords();
        Image image = this.getIcone();
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        g.drawImage(this.getIcone(), coord_usine[0] - width / 2, coord_usine[1] - height / 2, null);

    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void stepUsine() {
        // TODO Faire l'appel à la vente
        // mise à jour des icones

        int interval = stock.getCapacite() / icones.size();
        for (int i = 1; i <= icones.size(); i++) {
            if (i * interval >= stock.getRemplissage()) {
                current_icone = i - 1;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Entrepot: " + "id=" + id + ", nom=" + nom + "\n");
        str.append(" stock:\n" + stock.toString());
        return str.toString();
    }

    @Override
    public void reserver(Materiau mat) {
        stock.reserver();

    }

    public double pourcent_remplissage() {
        return ((double) stock.getRemplissage()) / ((double) stock.getCapacite());
    }

    @Override
    public void setDestination(Usine usine) {
    }

}
