package be.ephec.model.pions;

import be.ephec.model.area.Area;

public class SpaceHunter extends Pion{
	
	public SpaceHunter(){
		setDead(false);
		setNbCase(2);
		setNbVie(2);
		setName("Chasseur Spatial");
	}

	@Override
	public boolean isPlacable(Area spaceMatrice, int x, int y) {
		if(y < 0 || y > (spaceMatrice.getSide()-2)) return false;
		for(int i = y; i <y+2; i++){
			if(spaceMatrice.getCase(x, i).isUse()) return false;
		}
		return true;
	}

	@Override
	public int putPiece(Area spaceMatrice, int x, int y) {
		if(!isPlacable(spaceMatrice, x, y)) return -1;
		for(int i = y; i <y+2; i++){
			spaceMatrice.getCase(x, i).becomePion(getName());
		}
		return 0;
	}

}
