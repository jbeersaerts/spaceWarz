package be.ephec.spacewarz.model.area;

import java.io.Serializable;

/**
 * La classe Coord repr�sente une coordonn�e (x;y)
 * 
 * @author Olivier Vroman & Jonathan Beersaerts
 *
 */
public class Coord implements Serializable{
	private static final long serialVersionUID = 1372780970136429950L;
	private int x;
	private int y;
	
	public Coord(){
		x = 0;
		y = 0;
	}
	
	public Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * M�thode toString principalement utilis�e pour le debug de l'application
	 */
	public String toString(){
		return("("+getX()+";"+getY()+")");
	}

}
