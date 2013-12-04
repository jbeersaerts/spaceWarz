package be.ephec.controler;

import be.ephec.model.area.Area;
import be.ephec.model.pions.AdmiralSpaceCraft;
import be.ephec.model.pions.DeathStar;
import be.ephec.model.pions.SpaceCraft;
import be.ephec.model.pions.SpaceHunter;

public class Controler {
	private Area gameArea; 
	
	public Controler(Area gameArea){
		this.gameArea = gameArea;
	}
	
	
	public int putPion(AdmiralSpaceCraft pion, int x, int y){
		return 0;
	}
	
	
	public int putPion(SpaceHunter pion, int x, int y){
		if(y > gameArea.getSide()-2) return -1;
		gameArea.getCase(x, y).setUsedBy(pion);
		pion.setCase(gameArea.getCase(x, y), 0);
		gameArea.getCase(x, y+1).setUsedBy(pion);
		pion.setCase(gameArea.getCase(x, y+1), 1);
		return 0;
	}
	
	
	public int putPion(SpaceCraft pion, int x, int y){
		return 0;
	}
	
	
	public int putPion(DeathStar pion, int x, int y){
		return 0;
	}
	
}
