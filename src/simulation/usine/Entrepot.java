package simulation.usine;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// TODO passer la classe en observable
public class Entrepot implements Usine {
    private int id;
    private String nom;
    private int[] coords;
    private List<Image> icones;

    // TODO implémenter le package materiau
    // TODO implémenter le package stratégie
    // private StockMateriau stock;
    // private StrategieVente strategieVente;

    public Entrepot(int id, String nom, int[] coords, List<String> icones_path) {
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
            if (image == null)
                System.out.println("FAIL LOAD");
            this.icones.add(image);
        }
    }

    public int[] getCoords() {
        return coords;
    }

    @Override
    public boolean peuRecevoir() {
        // TODO
        return false;
    }

    @Override
    public void recevoirMateriau() {
        // TODO

    }

    public Image getIcone() {
        // TODO calculer les icones en fonction de l'avancement
        return icones.get(0);
    }

}
