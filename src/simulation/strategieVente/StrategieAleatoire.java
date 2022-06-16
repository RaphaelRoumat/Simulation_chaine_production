package simulation.strategieVente;
import java.util.Random;

public class StrategieAleatoire implements StrategieVente {
    private static Random rand = new Random();
    private static double proba = 0.001;
    @Override
    public boolean doitVendre(double depuis_vente) {
        if(rand.nextDouble() <= proba) return true;
        return false;
    }
    
}
