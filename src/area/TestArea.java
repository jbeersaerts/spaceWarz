package area;

import pions.DeathStar;

public class TestArea {
	
	public static void main(String[] args){
		Area are = new Area(10);
		DeathStar death = new DeathStar();
		System.out.println(death.isPlacable(are, 0, 0));
		System.out.println(death.putPiece(are, 5,5 ));
		are.affiche();
	}

}
