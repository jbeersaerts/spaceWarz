package be.ephec.controler;

import be.ephec.model.area.Area;
import be.ephec.model.pions.AdmiralSpaceCraft;
import be.ephec.model.pions.DeathStar;
import be.ephec.model.pions.Pion;
import be.ephec.model.pions.SpaceCraft;
import be.ephec.model.pions.SpaceHunter;

public class Controler {
	private Area gameArea;
	
	public Controler(Area gameArea){
		this.gameArea = gameArea;
	}
	
	/**
	 * Put the specialised Pion on the gameArea at the given position
	 * 
	 * @param pion Pion who will place into the Area
	 * @param x x position
	 * @param y y position
	 * @return Return 0 if the placement is OK or -1 if it's not possible to place the Pion at given position.
	 * 
	 */
	
	public int putPion(AdmiralSpaceCraft pion, int x, int y){
		if(AdmiralSpaceCraft.getNbInstance() == 1) return -1;
		if(x > gameArea.getSide()-4) return -1;
		for(int i = x; i<x+4; i++){
			if(gameArea.getCase(i, y).isCannotBeUsed() == true && 
			   gameArea.getCase(i, y).getUsedBy() != null) return -1;
		}
		for(int i = x, j = 0; i<x+4; i++, j++){
			gameArea.getCase(i, y).setUsedBy(pion);
			gameArea.getCase(i ,y).setCannotBeUsed(true);
			pion.setCase(gameArea.getCase(i, y), j);
		}
		AdmiralSpaceCraft.setNbInstance(AdmiralSpaceCraft.getNbInstance()+1);
		return 0;
	}
	
	public int putPion(SpaceHunter pion, int x, int y){
		if(SpaceHunter.getNbInstance() == 2) return -1;
		if(y > gameArea.getSide()-2) return -1;
		for(int i = y;i<y+2;i++){
			if(gameArea.getCase(x, i).isCannotBeUsed() == true && 
			   gameArea.getCase(x, i).getUsedBy() != null) return -1;
		}
		for(int i = y, j = 0; i<y+2; i++, j++){
			gameArea.getCase(x, i).setUsedBy(pion);
			gameArea.getCase(x ,i).setCannotBeUsed(true);
			pion.setCase(gameArea.getCase(x, i), j);
		}
		SpaceHunter.setNbInstance(SpaceHunter.getNbInstance()+1);
		return 0;
	}

	public int putPion(SpaceCraft pion, int x, int y){
		if(SpaceCraft.getNbInstance() == 2) return -1;
		if(x<0 || x > gameArea.getSide()-2) return -1;
		if(y<0 || y > gameArea.getSide()-2) return -1;
		if(gameArea.getCase(x, y).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y).getUsedBy() != null) return -1;
		if(gameArea.getCase(x+1, y).isCannotBeUsed() == true && 
		   gameArea.getCase(x+1, y).getUsedBy() != null) return -1;
		if(gameArea.getCase(x, y+1).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y+1).getUsedBy() != null) return -1;
			
		gameArea.getCase(x, y).setUsedBy(pion);
		gameArea.getCase(x ,y).setCannotBeUsed(true);
		pion.setCase(gameArea.getCase(x, y), 0);

		gameArea.getCase(x+1, y).setUsedBy(pion);
		gameArea.getCase(x+1 ,y).setCannotBeUsed(true);
		pion.setCase(gameArea.getCase(x+1, y), 1);

		gameArea.getCase(x, y+1).setUsedBy(pion);
		gameArea.getCase(x ,y+1).setCannotBeUsed(true);
		pion.setCase(gameArea.getCase(x, y+1), 2);
		SpaceCraft.setNbInstance(SpaceCraft.getNbInstance()+1);
		return 0;
	}
	
	public int putPion(DeathStar pion, int x, int y){
		if(DeathStar.getNbInstance() == 1) return -1;
		if(x<1 || x > gameArea.getSide()-2) return -1;
		if(y<1 || y > gameArea.getSide()-2) return -1;
		for(int i = x-1; i < x+2 ; i++){
			if(gameArea.getCase(i, y).isCannotBeUsed() == true && 
			   gameArea.getCase(i, y).getUsedBy() != null) return -1;
		}
		if(gameArea.getCase(x, y-1).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y-1).getUsedBy() != null) return -1;
		if(gameArea.getCase(x, y+1).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y+1).getUsedBy() != null) return -1;

		for(int i = x-1, j = 0; i < x+2 ; i++, j++){
			gameArea.getCase(i, y).setUsedBy(pion);
			gameArea.getCase(i ,y).setCannotBeUsed(true);
			pion.setCase(gameArea.getCase(i, y), j);
		}
		gameArea.getCase(x, y-1).setUsedBy(pion);
		gameArea.getCase(x ,y-1).setCannotBeUsed(true);
		pion.setCase(gameArea.getCase(x, y-1), 3);
		
		gameArea.getCase(x, y+1).setUsedBy(pion);
		gameArea.getCase(x ,y+1).setCannotBeUsed(true);
		pion.setCase(gameArea.getCase(x, y+1), 4);
		
		DeathStar.setNbInstance(DeathStar.getNbInstance()+1);
		
		return 0;
	}
	/**
	 * Method who shot on the (x;y) position
	 * 
	 * @param x x position
	 * @param y y position
	 * @return Return a Pion if it was touch or null if there are no Pion on given position
	 * 
	 */
	public Pion fireOnCase(int x, int y){
		if(gameArea.getCase(x, y).getUsedBy() != null){
			gameArea.getCase(x, y).getUsedBy().isTouch();
			gameArea.getCase(x, y).setTouch(true);
			return gameArea.getCase(x, y).getUsedBy();
		}
		gameArea.getCase(x, y).setTouch(true);
		return null;
	}
	
	public String touchOrExplod(Pion touchPion){
		if(touchPion.isDead()) return(touchPion.getName()+" a été touché et a explosé");
		return(touchPion.getName()+" a été touché");
	}
	
	public void resetPlacement(){
		for(int i = 0; i<gameArea.getSide();i++){
			for(int j = 0; j<gameArea.getSide();j++){
				gameArea.getCase(i, j).setUsedBy(null);
				gameArea.getCase(i, j).setCannotBeUsed(false);
			}
		}
	}
	
}
