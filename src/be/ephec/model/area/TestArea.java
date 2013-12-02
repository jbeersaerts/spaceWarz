package be.ephec.model.area;

import be.ephec.model.pions.*;

public class TestArea {
	
	public static void main(String[] args){
		Area are = new Area(10);
		DeathStar death = new DeathStar();
		SpaceCraft craft = new SpaceCraft();
		AdmiralSpaceCraft admir = new AdmiralSpaceCraft();
		SpaceHunter hunt1 = new SpaceHunter();
		SpaceHunter hunt2 = new SpaceHunter();
		
		System.out.println(death.isPlacable(are, 0, 0));
		System.out.println(death.putPiece(are, 8,8 ));
		craft.putPiece(are, 0, 1);
		admir.putPiece(are, 6, 0);
		hunt1.putPiece(are, 2, 7);
		hunt2.putPiece(are, 4, 5);
		are.affiche();
	}

}
