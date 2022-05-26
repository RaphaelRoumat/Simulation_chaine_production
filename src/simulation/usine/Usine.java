package simulation.usine;

import java.awt.Image;
import java.awt.Graphics;


public interface Usine {
    public boolean peuRecevoir();

    public void recevoirMateriau();

    public int[] getCoords();

    public Image getIcone();
    public void drawUsine(Graphics g);
}
