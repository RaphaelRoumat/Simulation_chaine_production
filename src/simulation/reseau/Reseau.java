package simulation.reseau;

import java.util.ArrayList;

import simulation.usine.Usine;
import java.awt.Graphics;
import java.awt.Image;

public class Reseau {
    private ArrayList<Usine> usines;
    private ArrayList<Chemin> chemins;
    // TODO implémenter Transition
    // private ArrayList<Transition> chemins;

    public Reseau() {
        chemins = new ArrayList<>();
        usines = new ArrayList<>();
    }

    public void ajouterChemin(Chemin c) {
        chemins.add(c);
    }

    public void enleverChemin(Chemin c) {
        chemins.remove(c);
    }

    public void ajouterUsine(Usine u) {
        usines.add(u);
    }

    public void enleverUsine(Usine u) {
        usines.remove(u);
    }

    public void drawReseau(Graphics g)
    {
        // Affichage des chemins
        for (Chemin chemin : chemins) {
            int[] coord_depart = chemin.getCoordDepart();
            int[] coord_arrivee = chemin.getCoordArrivee();
            g.drawLine(coord_depart[0], coord_depart[1], coord_arrivee[0], coord_arrivee[1]);
        }

        // Affichage des usines
        for (Usine usine : usines) {
            int[] coord_usine = usine.getCoords();
            Image image = usine.getIcone();
            int width = image.getWidth(null);
            int height = image.getHeight(null);

            g.drawImage(usine.getIcone(), coord_usine[0] - width/2, coord_usine[1] - height/2, null);
        }
    }
}
