package simulation.usine;

import java.awt.Image;

public interface Usine {
    public boolean peuRecevoir();

    public void recevoirMateriau();

    public int[] getCoords();

    public Image getIcone();
}
