package simulation.reseau;

import simulation.usine.Usine;
import java.awt.Graphics;


public class Chemin {
    private Usine depart;
    private Usine arrivee;
    private double[] vecteur_unitaire = new double[2];

    public Chemin(Usine depart, Usine arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        // TODO ajouter le calcul de vecteur uniteur en fonction des coordonnées des
        // usines
    }

    public double[] getVecteur_unitaire() {
        return this.vecteur_unitaire;
    }

    public int[] getCoordDepart()
    {
        return depart.getCoords();
    }

    public int[] getCoordArrivee()
    {
        return arrivee.getCoords();

    }

    public void drawChemin(Graphics g)
    {
        int[] coord_depart = this.getCoordDepart();
        int[] coord_arrivee = this.getCoordArrivee();
        g.drawLine(coord_depart[0], coord_depart[1], coord_arrivee[0], coord_arrivee[1]);
    }


}
