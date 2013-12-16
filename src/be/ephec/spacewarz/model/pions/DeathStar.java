package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 *      
 *   La classe {@link DeathStar} h�rite de la classe {@link Pion} repr�sente l'�toile Noire, qui est compos�
 *   de cinq cases dispos�es en croix.
 *      
 * 
 * @author Olivier Vroman & Jonathan Beersaerts
 */

public class DeathStar extends Pion {
	private static int nbInstance;
	
	public DeathStar(){
		setName("Etoile Noire");
		setNbCase(5);
		setNbVie(5);
		setDead(false);
		setTbCase(new Case[5]);
	}

	/**
	 * Permet d'obtenir le nombre d'instance de la classe en cours dans l'application 
	 * @return le nombre d'instance de la classe
	 */
	public static int getNbInstance() {
		return nbInstance;
	}

	/**
	 * Permet de modifier le nombre d'instance de la classe en cours dans l'application
	 * @param nbInstance la nouvelle valeur du nombre d'instance
	 */
	public static void setNbInstance(int nbInstance) {
		DeathStar.nbInstance = nbInstance;
	}
	
	
}
