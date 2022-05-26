package simulation;

public class Simulation {

	/**
	 * Cette classe repr�sente l'application dans son ensemble.
	 */
	public static void main(String[] args) {
		FenetrePrincipale fenetre = new FenetrePrincipale();
		Environnement environnement = new Environnement();
		environnement.addPropertyChangeListener(fenetre);
		environnement.execute();
	}

}
