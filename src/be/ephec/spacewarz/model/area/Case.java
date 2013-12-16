package be.ephec.spacewarz.model.area;

import be.ephec.spacewarz.model.pions.Pion;

/**
 * La classe Case représente une case constituant la grille de jeu, sur laquelle on peut poser des Pion
 * 
 * @author Olivier Vroman & Jonathan Beersaerts
 *
 */
public class Case{
	private Coord position;
	private boolean touch;
	private boolean cannotBeUsed;
	private Pion usedBy;
	
	public Case(){
		touch = false;
		usedBy = null;
	}
	
	public Case(int x, int y){
		position = new Coord(x,y);
		touch = false;
		cannotBeUsed = false;
		usedBy = null;
	}

	public boolean isTouch() {
		return touch;
	}
	public void setTouch(boolean touch) {
		this.touch = touch;
	}
	
	/**
	 * Permet d'obtenir la position de la case, position de type Coord
	 * @return position de la case, de type Coord
	 */
	public Coord getPosition() {
		return position;
	}

	public void setPosition(Coord position) {
		this.position = position;
	}

	public boolean isCannotBeUsed() {
		return cannotBeUsed;
	}

	public void setCannotBeUsed(boolean cannotBeUsed) {
		this.cannotBeUsed = cannotBeUsed;
	}

	/**
	 * Permet d'obtenir par quel pion la Case est utilisée
	 * @return la référence du Pion utilisant la case.
	 */
	public Pion getUsedBy() {
		return this.usedBy;
	}

	
	/**
	 * Permet de modifier par quel pion la Case est utilisée
	 * @param usedBy Pion par lequel la Case sera utilisée
	 */
	public void setUsedBy(Pion usedBy) {
		this.usedBy = usedBy;
	}
	
	
	/**
	 * Modifie la case afin qu'elle soit utilisée par un Objet pion donné 
	 * 
	 * @param usedBy : la référence de l'objet Pion
	 */
	public void becomePion(Pion usedBy){
		this.setUsedBy(usedBy);
	}

	
	/**
	 * Méthode toString principalement utilisée pour le debug de l'application
	 */
	public String toString(){
		return(position.getX()+":"+position.getY());
	}

}
