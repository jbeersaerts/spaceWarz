package be.ephec.model.pions;

import be.ephec.model.area.Case;

/**
 *      _ _ _ _
 *     |_|_|_|_|   représentation sur la grille
 *       
 */

public class AdmiralSpaceCraft extends Pion{
	
	public AdmiralSpaceCraft(){
		setName("Vaisseau Amiral");
		setNbCase(4);
		setDead(false);
		setTbCase(new Case[4]);
	}

}
