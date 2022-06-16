package simulation;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

import simulation.reseau.Reseau;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private Reseau reseau = null;

	public void updateReseau(Reseau reseau) {
		this.reseau = reseau;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.white);
		g.setColor(Color.white);
		if (reseau == null) {
			g.drawString("Aucun fichier XML selectionné", 20, 20);
		} else {

			reseau.drawReseau(g);
		}

	}

}