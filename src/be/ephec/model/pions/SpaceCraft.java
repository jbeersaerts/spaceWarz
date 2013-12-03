package be.ephec.model.pions;

import be.ephec.model.area.Area;

public class SpaceCraft extends Pion{
	
	public SpaceCraft(){
		setDead(false);
		setNbCase(3);
		setNbVie(3);
		setName("Vaisseau");
	}

	public boolean isPlacable(Area spaceMatrice, int x, int y) {
		if(x < 0 || x >(spaceMatrice.getSide()-2)) return false;
		if(y < 1 || y >(spaceMatrice.getSide()-1)) return false; 
		if(spaceMatrice.getCase(x, y).isUse()) return false; 
		if(spaceMatrice.getCase(x+1, y).isUse()) return false; 
		if(spaceMatrice.getCase(x, y-1).isUse()) return false;
		return true;
	}

	public int putPiece(Area spaceMatrice, int x, int y) {
		if(!isPlacable(spaceMatrice, x, y)) return -1;
		spaceMatrice.getCase(x, y).becomePion(getName()); 
		spaceMatrice.getCase(x+1, y).becomePion(getName());  
		spaceMatrice.getCase(x, y-1).becomePion(getName());
		return 0;
	}

}
