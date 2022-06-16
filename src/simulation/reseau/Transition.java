package simulation.reseau;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;

import simulation.materiau.Materiau;
import simulation.usine.Usine;

public class Transition {
    private Chemin chemin;
    private double x, y;
    private Materiau materiau;
    private Image icone;

    public Transition(Usine depart, Usine arrivee, Materiau materiau) {
        super();
        chemin = new Chemin(depart, arrivee);
        x = (double) depart.getCoords()[0];
        y = (double) depart.getCoords()[1];

        this.materiau = materiau;

        Image image = null;
        try {
            image = ImageIO.read(new File("src/ressources/" + materiau.getNom() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.icone = image;
        arrivee.reserver(materiau);
    }

    public boolean stepTransition() {
        double[] unitv = chemin.getVecteur_unitaire();

        x += unitv[0];
        y += unitv[1];
        // Détecter quand le materiau est arriver avec les coordonnées

        if (distance() < 10) {
            chemin.getArrivee().recevoirMateriau(materiau);
            return true;
        }
        return false;
    }

    public double distance() {
        double distance;

        var coords = chemin.getCoordArrivee();
        distance = Math.sqrt((x - coords[0]) * (x - coords[0]) + (y - coords[1]) * (y - coords[1]));
        return distance;
    }

    public void drawTransition(Graphics g) {
        int width = icone.getWidth(null);
        int height = icone.getHeight(null);

        int[] coord_materiau = { (int) Math.ceil(x), (int) Math.ceil(y) };

        g.drawImage(icone, coord_materiau[0] - width / 2, coord_materiau[1] -
                height / 2, null);
    }

    public Chemin getChemin() {
        return this.chemin;
    }

    public void setChemin(Chemin chemin) {
        this.chemin = chemin;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Materiau getMateriau() {
        return this.materiau;
    }

    public void setMateriau(Materiau materiau) {
        this.materiau = materiau;
    }

    public Image getIcone() {
        return this.icone;
    }

    public void setIcone(Image icone) {
        this.icone = icone;
    }

}
