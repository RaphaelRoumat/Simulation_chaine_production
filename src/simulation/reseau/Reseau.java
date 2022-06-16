package simulation.reseau;

import java.util.ArrayList;

import simulation.usine.Usine;
import java.awt.Graphics;

public class Reseau {
    private ArrayList<Usine> usines;
    private ArrayList<Chemin> chemins;
    private ArrayList<Transition> transitions;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Reseau() {
        chemins = new ArrayList<>();
        usines = new ArrayList<>();
        transitions = new ArrayList<>();
    }

    public ArrayList<Transition> getTransitions() {
        return this.transitions;
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

    public void ajouterTransition(Transition t) {
        transitions.add(t);
    }

    public void enleverTransition(Transition t) {
        transitions.remove(t);
    }

    public void drawReseau(Graphics g) {
        // Affichage des chemins
        for (Chemin chemin : chemins) {
            chemin.drawChemin(g);
        }

        // Affichage des transitions
        for (Transition transition : transitions) {
            transition.drawTransition(g);
        }
        // Affichage des usines
        for (Usine usine : usines) {
            usine.drawUsine(g);
        }

    }

    public void stepReseau() {

        for (Usine usine : usines) {
            usine.stepUsine();
        }

        Transition[] enlever = new Transition[transitions.size()];
        int counter = 0;
        for (Transition transition : transitions) {
            if (transition.stepTransition()) {
                enlever[counter] = transition;
                counter++;
            }
        }

        for (int i = 0; i < counter; i++) {
            enleverTransition(enlever[i]);
        }

    }

    public ArrayList<Usine> getUsines() {
        return this.usines;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("### Réseau:\n");
        str.append(" ##Usines:\n");

        for (Usine usine : usines) {
            str.append(ANSI_RED + "  #" + ANSI_RESET + usine.toString() + "\n");
        }

        str.append(" ## Chemins:\n");
        for (Chemin chemin : chemins) {
            str.append("  #" + chemin.toString() + "\n");
        }

        return str.toString();
    }

}
