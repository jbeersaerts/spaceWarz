package be.ephec.model.pions;

import be.ephec.model.area.Case;
/**     _
 *     |_|  
 *     |_|  repr�sentation sur la grille
 *       
 */

public class SpaceHunter extends Pion{
	
	public SpaceHunter(){
		setName("Chasseur Spatial");
		setNbCase(2);
		setNbVie(2);
		setDead(false);
		setTbCase(new Case[2]);
	}

}
