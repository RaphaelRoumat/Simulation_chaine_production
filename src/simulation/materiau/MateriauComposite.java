package simulation.materiau;


public class MateriauComposite extends Materiau{

    Materiau[] composants;

    public MateriauComposite(String nom, int idOrigine, Materiau[] composants) {
        super(nom, idOrigine);
        this.composants = composants;
    }


    public Materiau[] getComposants() {
        return this.composants;
    }


    public String toString() {
        return super.toString() + "{" +
            " composants='" + getComposants() + "'" +
            "}";
    }
    

    
}
