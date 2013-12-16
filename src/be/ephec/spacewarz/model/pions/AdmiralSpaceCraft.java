package be.ephec.spacewarz.model.pions;

import be.ephec.spacewarz.model.area.Case;

/**
 *   La classe {@link AdmiralSpaceCraft} hérite de la classe {@link Pion} représente le vaisseaux Amiral, qui est composé
 *   de quatres cases disposées horizontalement.
 *     
 *   @author Olivier Vroman & Jonathan Beersaerts    
 */

public class AdmiralSpaceCraft extends Pion{
	
	private static int nbInstance;
	
	public AdmiralSpaceCraft(){
		setName("Vaisseau Amiral");
		setNbCase(4);
		setNbVie(4);
		setDead(false);
		setTbCase(new Case[4]);
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
		AdmiralSpaceCraft.nbInstance = nbInstance;
	}

	
}
