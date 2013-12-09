package be.ephec.view.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import be.ephec.view.MyJLabels;;

/**
 * 
 * MouseListener pour l'effet relief lorsque l'on passe sur les grilles de jeu avec la souris
 * 
 * @author O.Vroman & J.Beersaerts
 *
 */


public class HoveringLabelListener extends MouseAdapter {

	
	public void mouseEntered(MouseEvent evt) {
		((MyJLabels)evt.getSource()).setBackground(new java.awt.Color(216,227,235));
		((MyJLabels)evt.getSource()).setOpaque(true);
	}
	
	public void mouseExited(MouseEvent evt) {
		((MyJLabels)evt.getSource()).setBackground(new java.awt.Color(247,247,247));
		((MyJLabels)evt.getSource()).setOpaque(true);
	}
	
}
