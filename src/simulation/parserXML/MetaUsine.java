package simulation.parserXML;

import java.util.ArrayList;

public class MetaUsine {
    private String type;
    private ArrayList<String> icones_path;
    private boolean entrepot = false;

    @Override
    public String toString() {
        return "{" +
                " type='" + getType() + "'" +
                ", icones_path='" + getIcones_path() + "'" +
                ", entrepot='" + isEntrepot() + "'" +
                "}";
    }

    public MetaUsine() {
        icones_path = new ArrayList<>();
    }

    public boolean isEntrepot() {
        return entrepot;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getIcones_path() {
        return this.icones_path;
    }

    public void addIcone(String path) {
        icones_path.add(path);
    }

    public void setAsEntrepot() {
        entrepot = true;
    }

}
