package be.ephec.model.pions;

import be.ephec.model.area.Area;

public class AdmiralSpaceCraft extends Pion{
	
	public AdmiralSpaceCraft(){
		setDead(false);
		setNbCase(4);
		setNbVie(4);
		setName("Vaisseau Amiral");
	}

	public boolean isPlacable(Area spaceMatrice, int x, int y) {
		if(x < 0 || x > (spaceMatrice.getSide()-4)) return false;
		for(int i = x; i<x+4;i++){
			if(spaceMatrice.getCase(i, y).isUse()) return false;
		}
		return true;
	}

	public int putPiece(Area spaceMatrice, int x, int y) {
		if(!isPlacable(spaceMatrice,x,y)) return -1;
		for(int i = x; i<x+4;i++){
			spaceMatrice.getCase(i, y).becomePion(getName());
		}
		return 0;
	}

}
