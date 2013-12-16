package be.ephec.spacewarz.model.area;

/**
 * La classe Area fait partie du modèle de l'application et regroupe une matrice d'objet de type Case .
 */
public class Area {
	
	private int side;
	private Case spaceMatrice[][];
	
	public Area(){
		side = 2;
		initSpaceMatrice(side);
	}
	
	/**
	 * Constructeur d'Area instancie un objet Area en fonction du coté qui lui est donné en paramètre.
	 *
	 * @param side : nombre de Case de coté pour la matrice.
	 */
	public Area(int side){
		this.side = side;
		initSpaceMatrice(this.side);
	}
		
	/**
	 * Cette méthode est appelée dans le constructeur de la classe afin de créer la matrice de Case.
	 *
	 * @param side : nombre de Case de coté pour la matrice.
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
	 * Permet d'obtenir le coté de la matrice de Case.
	 *
	 * @return entier représentant le coté de la matrice de Case.
	 */
	public int getSide(){
		return side;
	}
	
	/**
	 * Permet d'obtenir une case de la matrice à la coordonnée voulue.
	 *
	 * @param x position d'abscisse.
	 * @param y position d'ordonnée
	 * @return la Case se trouvant à la coordonnée désirée
	 */
	public Case getCase(int x, int y){
		return spaceMatrice[y][x];
	}
	
	
	/**
	 * Methode utilisée pour le debug afin d'afficher la matrice de case en fonction du toString de la classe Case.
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
