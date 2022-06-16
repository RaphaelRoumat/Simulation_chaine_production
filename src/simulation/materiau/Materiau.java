package simulation.materiau;

import java.util.Objects;

public class Materiau {
    private String nom;

    public Materiau(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public String toString() {
        return "Materiau: nom=" + nom;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        Materiau materiau = (Materiau) o;

        return materiau.getNom().equals(getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

}
