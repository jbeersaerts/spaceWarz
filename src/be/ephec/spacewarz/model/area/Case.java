package be.ephec.spacewarz.model.area;

import be.ephec.spacewarz.model.pions.Pion;

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

	public Pion getUsedBy() {
		return this.usedBy;
	}

	public void setUsedBy(Pion usedBy) {
		this.usedBy = usedBy;
	}
	
	
	/**
	 * Modify the case to become a pion 
	 * 
	 * @param name of the pion who use the case
	 */
	public void becomePion(Pion usedBy){
		this.setUsedBy(usedBy);
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * Je la modifie un peu comme je veux pour afficher ce qui m'intéresse dans la console
	 *  
	 */
	public String toString(){
		return(position.getX()+":"+position.getY());
	}

}
