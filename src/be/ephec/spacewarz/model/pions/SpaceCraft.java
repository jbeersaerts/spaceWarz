package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**     _
 *     |_|_  
 *     |_|_|  représentation sur la grille
 *       
 */

public class SpaceCraft extends Pion{
	
	private static int nbInstance;
	
	public SpaceCraft(){
		setName("Vaisseau");
		setNbCase(3);
		setNbVie(3);
		setDead(false);
		setTbCase(new Case[3]);
	}

	public static int getNbInstance() {
		return nbInstance;
	}

	public static void setNbInstance(int nbInstance) {
		SpaceCraft.nbInstance = nbInstance;
	}
	
	

}
