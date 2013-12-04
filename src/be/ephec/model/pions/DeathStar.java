package be.ephec.model.pions;

/**
 *        _
 *      _|_|_
 *     |_|_|_|    représentation sur la grille
 *       |_|
 * 
 * 
 *
 */

public class DeathStar extends Pion {
	
	public DeathStar(){
		setName("Etoile Noire");
		setNbCase(5);
		setDead(false);
	}
}
