package simulation.parserXML;

public class MetaStock {
    public String typeStock;
    public int capacite;

    public MetaStock(String typeStock, int capacite) {
        this.typeStock = typeStock;
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "{" +
                " typeStock='" + typeStock + "'" +
                ", capacite='" + capacite + "'" +
                "}";
    }

}
