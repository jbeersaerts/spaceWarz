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
	
	public DeathStar(){
		setName("Etoile Noire");
		setNbCase(5);
		setNbVie(5);
		setDead(false);
		setTbCase(new Case[5]);
	}
}
