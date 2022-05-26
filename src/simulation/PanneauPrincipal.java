package simulation;

import java.awt.Graphics;
import javax.swing.JPanel;

import simulation.reseau.Reseau;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private Reseau reseau = null;

	public void updateReseau(Reseau reseau) {
		this.reseau = reseau;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (reseau == null) {
			g.drawString("Aucun fichier XML selectionné", 20, 20);
		} else {
			reseau.drawReseau(g);
		}
		// On ajoute � la position le delta x et y de la vitesse
		// position.translate(vitesse.x, vitesse.y);
		// g.fillRect(position.x, position.y, taille, taille);
	}

}