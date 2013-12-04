package be.ephec.model.area;

public class Area {
	
	private int side;
	private Case spaceMatrice[][];
	
	public Area(){
		side = 2;
		initSpaceMatrice(side);
	}
	
	public Area(int side){
		this.side = side;
		initSpaceMatrice(this.side);
	}
		
	private void initSpaceMatrice(int side){
		spaceMatrice = new Case[side][side];
		for(int i = 0; i < side;i++){
			for(int j = 0; j < side;j++){
				spaceMatrice[i][j] = new Case(j,i);
			}
		}	
	}
	
	public int getSide(){
		return side;
	}
	
	public Case getCase(int x, int y){
		return spaceMatrice[y][x];
	}
	
	public void setSide(int side){
		this.side = side;
	}
	
	public void affiche(){
		for(int i = 0; i < side;i++){
			for(int j = 0; j < side;j++){
				System.out.print(spaceMatrice[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
}
