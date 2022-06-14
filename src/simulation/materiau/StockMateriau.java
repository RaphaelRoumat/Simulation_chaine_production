package simulation.materiau;


public class StockMateriau {
    private String typeMateriau;
    private Materiau[] stock;
    private int remplissage = 0;


    public StockMateriau(String typeMateriau, int capacite) {
        this.typeMateriau = typeMateriau;
        this.stock = new Materiau[capacite];
    }

    public boolean is_full()
    {
        return (remplissage == stock.length);
    }


    public String getTypeMateriau() {
        return this.typeMateriau;
    }

    public Materiau[] getStock() {
        return this.stock;
    }
    

    public void add_Materiau(Materiau mat)
    {
        if(mat.getNom().equals(typeMateriau) && !is_full())
        {
            stock[remplissage] = mat;
            remplissage ++;
        }
    }
    
}
