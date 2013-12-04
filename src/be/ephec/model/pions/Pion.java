package be.ephec.model.pions;

import be.ephec.model.area.Case;


public class Pion {
	private String name;
	private int nbCase;
	private int nbVie;
	private boolean dead;
	private Case tbCase[];
	
	
	public int getNbCase() {
		return nbCase;
	}
	
	public void setNbCase(int nbCase) {
		this.nbCase = nbCase;
	}
	
	
	public int getNbVie() {
		return nbVie;
	}

	public void setNbVie(int nbVie) {
		this.nbVie = nbVie;
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

	public Case[] getTbCase() {
		return tbCase;
	}

	public void setTbCase(Case[] tbCase) {
		this.tbCase = tbCase;
	}
	
	public Case getCase(int i){
		return tbCase[i];
	}
	
	public void setCase(Case c, int i){
		this.tbCase[i] = c;
	}
	
	public void isTouch(){
		nbVie = nbVie -1;
		updateDeadAfterTouch();
	}

	private void updateDeadAfterTouch(){
		if(nbVie == 0) setDead(true);
	}
	
	public String toString(){
		return name;
	}
	
}
