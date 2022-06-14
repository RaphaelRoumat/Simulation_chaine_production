package simulation.materiau;


public class Materiau {
    private String nom;
    private int idOrigine;


    public Materiau(String nom, int idOrigine) {
        this.nom = nom;
        this.idOrigine = idOrigine;
    }

    public String getNom() {
        return this.nom;
    }

    public int getIdOrigine() {
        return this.idOrigine;
    }

    public String toString() {
        return "{" +
            " nom='" + getNom() + "'" +
            ", idOrigine='" + getIdOrigine() + "'" +
            "}";
    }

    
}
