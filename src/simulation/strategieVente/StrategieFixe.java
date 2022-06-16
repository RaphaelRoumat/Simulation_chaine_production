package simulation.strategieVente;

public class StrategieFixe implements StrategieVente{

    @Override
    public boolean doitVendre(double depuis_vente) {
        if(depuis_vente >= 800 ) return true;
        return false;
    }
    
}
