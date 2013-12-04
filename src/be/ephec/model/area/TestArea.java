package be.ephec.model.area;

import be.ephec.model.pions.*;

public class TestArea {
	
	public static void main(String[] args){
		Area are = new Area(10);
		DeathStar death = new DeathStar();
		SpaceCraft craft = new SpaceCraft();
		AdmiralSpaceCraft admir = new AdmiralSpaceCraft();
		are.affiche();
	}

}
