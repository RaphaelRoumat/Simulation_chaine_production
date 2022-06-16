package simulation.reseau;

import simulation.usine.Usine;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Color;

public class Chemin {
    private Usine depart;
    private Usine arrivee;
    private double[] vecteur_unitaire = new double[2];

    public Chemin(Usine depart, Usine arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        int[] coord_depart = depart.getCoords();
        int[] coord_arrivee = arrivee.getCoords();

        int[] vecteur = { coord_arrivee[0] - coord_depart[0], coord_arrivee[1] - coord_depart[1] };
        double norm = Math.sqrt((double) (vecteur[0] * vecteur[0] + vecteur[1] * vecteur[1]));

        vecteur_unitaire[0] = vecteur[0] / norm;
        vecteur_unitaire[1] = vecteur[1] / norm;
    }

    public double[] getVecteur_unitaire() {
        return this.vecteur_unitaire;
    }

    public int[] getCoordDepart() {
        return depart.getCoords();
    }

    public int[] getCoordArrivee() {
        return arrivee.getCoords();

    }

    public void drawChemin(Graphics g) {
        int[] coord_depart = this.getCoordDepart();
        int[] coord_arrivee = this.getCoordArrivee();
        g.setColor(Color.BLACK);
        g.drawLine(coord_depart[0], coord_depart[1], coord_arrivee[0], coord_arrivee[1]);
    }

    public Usine getDepart() {
        return this.depart;
    }

    public Usine getArrivee() {
        return this.arrivee;
    }

}
