package simulation.reseau;

import java.util.ArrayList;
 
import simulation.usine.Usine;
import java.awt.Graphics;

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
            chemin.drawChemin(g);
        }

        // Affichage des usines
        for (Usine usine : usines) {
            usine.drawUsine(g);
        }
    }
}
