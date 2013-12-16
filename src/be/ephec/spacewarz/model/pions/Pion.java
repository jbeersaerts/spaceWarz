package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 * La classe {@link Pion} repr�sente un g�n�ralisation des autres Pion du packages :
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
	 * Permet de savoir le nombre de case utilis�e par le Pion.
	 * @return nombre de case utilis�e par le pion.
	 */
	public int getNbCase() {
		return nbCase;
	}
	
	/**
	 * Permet d'assigner une nouvelle valeur au nombre de case utilis�e par le Pion.
	 * @param nbCase nouvelle valeur de nombre de case utiis�e par le Pion.
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
	 * @param nbVie nouvelle valeur assign�e au nombre de vie de l'instance en cours.
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
	 * Permet de modifier l'�tat logique "mort" du Pion.
	 * @param dead nouvelle valeur de l'�tat logique "mort" de l'instance en cours.
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
	 * Permet d'attribuer un nom � l'instance en cours.
	 * @param name nom attribu� � l'instance en cours.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * permet d'obtenir le tableau de case utilis�e par l'instance en cours.
	 * @return tableau de Case[] repr�sentant le case sur lesquelle l'instance en cours est plac�e.
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
	 * Permet d'obtenir une case du tableau de case utilis� par le Pion.
	 * @param i indice dans le tableau de case.
	 * @return la case du tableau � l'indice i du tableau.
	 */
	public Case getCase(int i){
		return tbCase[i];
	}
	
	/**
	 * Permet de modifier une case du tableau de case utilis�e par le Pion .
	 * @param c la nouvelle case.
	 * @param i l'indice ou va se mettre la nouvelle case.
	 */
	public void setCase(Case c, int i){
		this.tbCase[i] = c;
	}
	
	/**
	 * m�thode �tant appel�e lorsque l'instance en cours � re�ue un tir,
	 * on d�cr�mente le nombre de vie et v�rifions si il n'est pas � 0 et nous actualisons
	 * en fonction la valeur logique "mort" de l'instance en cours
	 */
	public void isShooted(){
		nbVie = nbVie -1;
		updateDeadAfterTouch();
	}

	/**
	 * m�thode appel�e par isShooted o� on actualise la valeur logique "mort"
	 * en fonction de nombre de vies restantes � l'instance en cours.
	 */
	private void updateDeadAfterTouch(){
		if(nbVie == 0) setDead(true);
	}
	
	/**
	 * M�thode toString principalement utilis�e pour le debug de l'application
	 */
	public String toString(){
		return name;
	}
	
}
