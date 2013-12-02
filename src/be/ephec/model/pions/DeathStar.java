package be.ephec.model.pions;

import be.ephec.model.area.Area;

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
		setDead(false);
		setNbCase(5);
		setNbVie(5);
		setName("Etoile Noire");
	}
	
	
	public boolean isPlacable(Area spaceMatrice, int x, int y){
		
		if(x < 1 || x >=(spaceMatrice.getSide()-1)) return false;
		if(y < 1 || y >= (spaceMatrice.getSide()-1)) return false; //arrayIndex.. exception FIXED =)
		if(spaceMatrice.getCase(x, y).isUse()) return false;
		if(spaceMatrice.getCase(x-1, y).isUse()) return false;
		if(spaceMatrice.getCase(x+1, y).isUse()) return false;
		if(spaceMatrice.getCase(x, y-1).isUse()) return false;
		if(spaceMatrice.getCase(x, y+1).isUse()) return false;
		return true;
	}
	

	public int putPiece(Area spaceMatrice, int x, int y) {
		
		if(!isPlacable(spaceMatrice,x,y)) return -1;
		spaceMatrice.getCase(x, y).becomePion(getName());
		spaceMatrice.getCase(x+1, y).becomePion(getName());
		spaceMatrice.getCase(x-1, y).becomePion(getName());
		spaceMatrice.getCase(x, y-1).becomePion(getName());
		spaceMatrice.getCase(x, y+1).becomePion(getName());
		return 0;
	}

}
