package be.ephec.model.pions;

import be.ephec.model.area.Case;
/**     _
 *     |_|  
 *     |_|  repr�sentation sur la grille
 *       
 */

public class SpaceHunter extends Pion{
	
	private static int nbInstance;
	
	public SpaceHunter(){
		setName("Chasseur Spatial");
		setNbCase(2);
		setNbVie(2);
		setDead(false);
		setTbCase(new Case[2]);
	}

	public static int getNbInstance() {
		return nbInstance;
	}

	public static void setNbInstance(int nbInstance) {
		SpaceHunter.nbInstance = nbInstance;
	}

	
	
}
