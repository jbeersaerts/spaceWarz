package be.ephec.model.pions;

import be.ephec.model.area.Case;


public class Pion {
	private String name;
	private int nbCase;
	private boolean dead;
	private Case tbCase[][];
	
	
	public int getNbCase() {
		return nbCase;
	}
	
	public void setNbCase(int nbCase) {
		this.nbCase = nbCase;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Case[][] getTbCase() {
		return tbCase;
	}

	public void setTbCase(Case[][] tbCase) {
		this.tbCase = tbCase;
	}

}
