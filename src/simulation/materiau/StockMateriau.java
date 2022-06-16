package simulation.materiau;

public class StockMateriau {
    private String typeMateriau;
    private Materiau[] stock;
    private int remplissage = 0;
    private int reservation = 0;

    public StockMateriau(String typeMateriau, int capacite) {
        this.typeMateriau = typeMateriau;
        this.stock = new Materiau[capacite];
    }

    public boolean is_full() {
        return remplissage == stock.length;
    }

    public void reserver() {
        reservation++;
    }

    public boolean is_fullyReserved() {
        return remplissage + reservation == stock.length;
    }

    public String getTypeMateriau() {
        return this.typeMateriau;
    }

    public Materiau[] getStock() {
        return this.stock;
    }

    public void add_Materiau(Materiau mat) {
        if (mat.getNom().equals(typeMateriau) && !is_full()) {
            stock[remplissage] = mat;
            remplissage++;
        }
        reservation--;
    }

    public int getRemplissage() {
        return remplissage;
    }

    public int getCapacite() {
        return stock.length;
    }

    public void clear() {
        for (int i = 0; i < stock.length; i++) {
            stock[i] = null;
        }
        remplissage = 0;
    }

    @Override
    public String toString() {
        return "StockMat: type=" + typeMateriau + ", remplissage=" + remplissage + ", reservations=" + reservation
                + ", capacite=" + stock.length;
    }

}
