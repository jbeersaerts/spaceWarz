package be.ephec.model.pions;

import be.ephec.model.area.Area;
import be.ephec.model.area.Case;

/**     _
 *     |_|  
 *     |_|  représentation sur la grille
 *       
 */

public class SpaceHunter extends Pion{
	
	public SpaceHunter(Area matrice, int x, int y){
		setName("Chasseur Spatial");
		setNbCase(2);
		setDead(false);
		setTbCase(new Case[2]);
	}

}
