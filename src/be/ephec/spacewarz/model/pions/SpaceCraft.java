package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 *   La classe {@link SpaceCraft} hérite de la classe {@link Pion} représente le vaisseau simple, qui est composé
 *   de trois cases disposées en L.
 *     
 *   @author Olivier Vroman & Jonathan Beersaerts    
 */

public class SpaceCraft extends Pion{
	
	private static int nbInstance;
	
	public SpaceCraft(){
		setName("Vaisseau");
		setNbCase(3);
		setNbVie(3);
		setDead(false);
		setTbCase(new Case[3]);
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
		SpaceCraft.nbInstance = nbInstance;
	}
	
	

}
