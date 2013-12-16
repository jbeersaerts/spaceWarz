package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 *   La classe {@link SpaceHunter} hérite de la classe {@link Pion} représente le chasseur spatial, qui est composé
 *   de deux cases disposées verticalement.
 *     
 *   @author Olivier Vroman & Jonathan Beersaerts    
 */

public class SpaceHunter extends Pion{
	
	private static int nbInstance;
	
	public SpaceHunter(){
		setName("Chasseur Spatial");
		setNbCase(2);
		setNbVie(2);
		setDead(false);
		setTbCase(new Case[2]);
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
		SpaceHunter.nbInstance = nbInstance;
	}

	
	
}
