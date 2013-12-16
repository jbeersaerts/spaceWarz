package be.ephec.spacewarz.model.area;

/**
 * La classe Area fait partie du mod�le de l'application et regroupe une matrice d'objet de type Case .
 */
public class Area {
	
	private int side;
	private Case spaceMatrice[][];
	
	public Area(){
		side = 2;
		initSpaceMatrice(side);
	}
	
	/**
	 * Constructeur d'Area instancie un objet Area en fonction du cot� qui lui est donn� en param�tre.
	 *
	 * @param side : nombre de Case de cot� pour la matrice.
	 */
	public Area(int side){
		this.side = side;
		initSpaceMatrice(this.side);
	}
		
	/**
	 * Cette m�thode est appel�e dans le constructeur de la classe afin de cr�er la matrice de Case.
	 *
	 * @param side : nombre de Case de cot� pour la matrice.
	 * 
	 */
	private void initSpaceMatrice(int side){
		spaceMatrice = new Case[side][side];
		for(int i = 0; i < side;i++){
			for(int j = 0; j < side;j++){
				spaceMatrice[i][j] = new Case(j,i);
			}
		}	
	}
	
	/**
	 * Permet d'obtenir le cot� de la matrice de Case.
	 *
	 * @return entier repr�sentant le cot� de la matrice de Case.
	 */
	public int getSide(){
		return side;
	}
	
	/**
	 * Permet d'obtenir une case de la matrice � la coordonn�e voulue.
	 *
	 * @param x position d'abscisse.
	 * @param y position d'ordonn�e
	 * @return la Case se trouvant � la coordonn�e d�sir�e
	 */
	public Case getCase(int x, int y){
		return spaceMatrice[y][x];
	}
	
	
	/**
	 * Methode utilis�e pour le debug afin d'afficher la matrice de case en fonction du toString de la classe Case.
	 */
	public void affiche(){
		for(int i = 0; i < side;i++){
			for(int j = 0; j < side;j++){
				System.out.print(spaceMatrice[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
}
