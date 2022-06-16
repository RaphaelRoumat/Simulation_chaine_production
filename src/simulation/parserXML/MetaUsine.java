package simulation.parserXML;

import java.util.ArrayList;

public class MetaUsine {
    private String type;
    private ArrayList<String> icones_path;
    private boolean is_entrepot = false;
    private ArrayList<MetaStock> entrees;
    private MetaStock sortie; // utilisé comme stock pour les entrepots, mit à capacité = -1 pour les usines
                              // de prod
    private int interval_prod;

    public MetaUsine() {
        icones_path = new ArrayList<>();
        entrees = new ArrayList<>();
    }

    public void addEntree(String typeStock, int capacite) {
        entrees.add(new MetaStock(typeStock, capacite));
    }

    public void setSortie(String typeStock, int capacite) {
        sortie = new MetaStock(typeStock, capacite);
    }

    public boolean isEntrepot() {
        return is_entrepot;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<MetaStock> getEntrees() {
        return this.entrees;
    }

    public MetaStock getSortie() {
        return this.sortie;
    }

    public ArrayList<String> getIcones_path() {
        return this.icones_path;
    }

    public void addIcone(String path) {
        icones_path.add(path);
    }

    public void setAsEntrepot() {
        is_entrepot = true;
    }

    public int getInterval_prod() {
        return this.interval_prod;
    }

    public void setInterval_prod(int interval_prod) {
        this.interval_prod = interval_prod;
    }

    @Override
    public String toString() {
        return "## META USINE {" +
                " type='" + getType() + "'" +
                ", is_entrepot='" + isEntrepot() + "'" +
                ", entrees='" + getEntrees() + "'" +
                ", sortie='" + getSortie() + "'" +
                "}\n";
    }

}
