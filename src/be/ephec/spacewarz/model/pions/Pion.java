package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 * La classe {@link Pion} représente un généralisation des autres Pion du packages :
 * <ul>
 * <li>{@link AdmiralSpaceCraft}</li>
 * <li>{@link DeathStar}</li>
 * <li>{@link SpaceCraft}</li>
 * <li>{@link SpaceHunter}</li>
 * </ul>
 * @author Olivier Vroman & Jonathan Beersaerts
 *
 */

public class Pion {
	private String name;
	private int nbCase;
	private int nbVie;
	private boolean dead;
	private Case tbCase[];
	
	/**
	 * Permet de savoir le nombre de case utilisée par le Pion.
	 * @return nombre de case utilisée par le pion.
	 */
	public int getNbCase() {
		return nbCase;
	}
	
	/**
	 * Permet d'assigner une nouvelle valeur au nombre de case utilisée par le Pion.
	 * @param nbCase nouvelle valeur de nombre de case utiisée par le Pion.
	 */
	public void setNbCase(int nbCase) {
		this.nbCase = nbCase;
	}
	
	/**
	 * Permet d'obtenir le nombre de vie restante de l'instance en cours.
	 * @return nombre de vie restante.
	 */
	public int getNbVie() {
		return nbVie;
	}

	/**
	 * Assigne une valeur au nombre de vie de l'instance en cours.
	 * @param nbVie nouvelle valeur assignée au nombre de vie de l'instance en cours.
	 */
	public void setNbVie(int nbVie) {
		this.nbVie = nbVie;
	}

	/**
	 * Permet de savoir si le Pion est mort ou non.
	 * @return vrai si le Pion est mort ( getNbVie() = 0 ) et faux si il ne l'est pas.
	 */
	public boolean isDead() {
		return dead;
	}
	
	/**
	 * Permet de modifier l'état logique "mort" du Pion.
	 * @param dead nouvelle valeur de l'état logique "mort" de l'instance en cours.
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	/**
	 * Permet d'obtenier le nom du Pion de l'instance en cours.
	 * @return nom du Pion de l'instance en cours.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Permet d'attribuer un nom à l'instance en cours.
	 * @param name nom attribué à l'instance en cours.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * permet d'obtenir le tableau de case utilisée par l'instance en cours.
	 * @return tableau de Case[] représentant le case sur lesquelle l'instance en cours est placée.
	 */
	public Case[] getTbCase() {
		return tbCase;
	}

	/**
	 * permet de modifier le tableau de case de l'instance en cours.
	 * @param tbCase nouveau tableau de case.
	 */
	public void setTbCase(Case[] tbCase) {
		this.tbCase = tbCase;
	}
	
	/**
	 * Permet d'obtenir une case du tableau de case utilisé par le Pion.
	 * @param i indice dans le tableau de case.
	 * @return la case du tableau à l'indice i du tableau.
	 */
	public Case getCase(int i){
		return tbCase[i];
	}
	
	/**
	 * Permet de modifier une case du tableau de case utilisée par le Pion .
	 * @param c la nouvelle case.
	 * @param i l'indice ou va se mettre la nouvelle case.
	 */
	public void setCase(Case c, int i){
		this.tbCase[i] = c;
	}
	
	/**
	 * méthode étant appelée lorsque l'instance en cours à reçue un tir,
	 * on décrémente le nombre de vie et vérifions si il n'est pas à 0 et nous actualisons
	 * en fonction la valeur logique "mort" de l'instance en cours
	 */
	public void isShooted(){
		nbVie = nbVie -1;
		updateDeadAfterTouch();
	}

	/**
	 * méthode appelée par isShooted où on actualise la valeur logique "mort"
	 * en fonction de nombre de vies restantes à l'instance en cours.
	 */
	private void updateDeadAfterTouch(){
		if(nbVie == 0) setDead(true);
	}
	
	/**
	 * Méthode toString principalement utilisée pour le debug de l'application
	 */
	public String toString(){
		return name;
	}
	
}
