package simulation.usine;

import java.awt.Graphics;
import java.awt.Image;

import simulation.materiau.Materiau;

public interface Usine {
    public boolean peuRecevoir(Materiau mat);

    public void recevoirMateriau(Materiau mat);

    public int[] getCoords();

    public Image getIcone();

    public void drawUsine(Graphics g);

    public void setDestination(Usine usine);

    public int getId();

    public String getNom();

    public void stepUsine();

    public void reserver(Materiau mat);
}
