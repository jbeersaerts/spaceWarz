package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 *      _ _ _ _
 *     |_|_|_|_|   représentation sur la grille
 *       
 */

public class AdmiralSpaceCraft extends Pion{
	
	private static int nbInstance;
	
	public AdmiralSpaceCraft(){
		setName("Vaisseau Amiral");
		setNbCase(4);
		setNbVie(4);
		setDead(false);
		setTbCase(new Case[4]);
	}

	public static int getNbInstance() {
		return nbInstance;
	}

	public static void setNbInstance(int nbInstance) {
		AdmiralSpaceCraft.nbInstance = nbInstance;
	}

	
}
