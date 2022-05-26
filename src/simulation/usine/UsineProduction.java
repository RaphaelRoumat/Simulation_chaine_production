package simulation.usine;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// TODO Passer la classe en observer
public class UsineProduction implements Usine {
    private int id;
    private String nom;
    private int[] coords = new int[2];
    private List<Image> icones;
    private int interval_production;
    private int depuis_production;
    // TODO implémenter le package materiau
    // private StockMateriau[] entrees;
    // private StockMateriau sortie;

    public UsineProduction(int id, String nom, int[] coords, List<String> icones_path) {
        this.id = id;
        this.nom = nom;
        this.coords = coords;

        this.icones = new ArrayList<Image>();

        for (String path : icones_path) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.icones.add(image);
        }
    }

    public int[] getCoords() {
        return coords;
    }

    public boolean peuRecevoir() {
        // TODO
        return false;
    }

    public void recevoirMateriau() {
        // TODO

    }

    private void Produire() {
        // TODO
    }

    public Image getIcone() {
        // TODO calculer les icones en fonction de l'avancement
        return icones.get(0);
    }

}
