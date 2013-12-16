package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 *      
 *   La classe {@link DeathStar} hérite de la classe {@link Pion} représente l'étoile Noire, qui est composé
 *   de cinq cases disposées en croix.
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
