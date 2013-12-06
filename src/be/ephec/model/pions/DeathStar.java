package be.ephec.model.pions;

import be.ephec.model.area.Case;

/**
 *        _
 *      _|_|_
 *     |_|_|_|    repr�sentation sur la grille
 *       |_|
 * 
 *    Case[y][x]
 *
 */

public class DeathStar extends Pion {
	private static int nbInstance;
	
	public DeathStar(){
		setName("Etoile Noire");
		setNbCase(5);
		setNbVie(5);
		setDead(false);
		setTbCase(new Case[5]);
	}

	public static int getNbInstance() {
		return nbInstance;
	}

	public static void setNbInstance(int nbInstance) {
		DeathStar.nbInstance = nbInstance;
	}
	
	
}
