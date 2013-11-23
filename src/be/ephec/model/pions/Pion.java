package be.ephec.model.pions;

import be.ephec.model.area.Area;

/**
 * Abstract class for pion of the game
 * @author Jiksaa
 *
 */

public abstract class Pion {
	private int nbCase;
	private int nbVie;
	private boolean dead;
	
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
	
	/**
	 * Specify if the given center of the piece allow to place the pion in the given Area.
	 * 
	 * @param spaceMatrice Area where we check if the pion is placable or not
	 * @param x absiss position of the pion center
	 * @param y ordonnal position of the pion center
	 * @return true if we can place the piece on the area or false if it's not possible
	 */
	abstract public boolean isPlacable(Area spaceMatrice, int x, int y);
	
	/**
	 * Put the piece on the given Area
	 * 
	 * @param spaceMatrice Area where we check if the pion is placable or not
	 * @param x absiss position of the pion center
	 * @param y ordonnal position of the pion center
	 * @return -1 if the piece can't be placed or 0 if there is no error
	 */
	abstract public int putPiece(Area spaceMatrice, int x, int y);

}
