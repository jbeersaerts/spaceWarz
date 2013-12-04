package be.ephec.model.pions;

import be.ephec.model.area.Case;

/**     _
 *     |_|_  
 *     |_|_|  représentation sur la grille
 *       
 */

public class SpaceCraft extends Pion{
	
	public SpaceCraft(){
		setName("Vaisseau");
		setNbCase(3);
		setDead(false);
		setTbCase(new Case[3]);
	}

}
