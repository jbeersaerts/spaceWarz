package be.ephec.spacewarz;

import be.ephec.controler.Controler;
import be.ephec.model.area.Area;
import be.ephec.model.pions.AdmiralSpaceCraft;
import be.ephec.model.pions.DeathStar;
import be.ephec.model.pions.SpaceCraft;
import be.ephec.model.pions.SpaceHunter;

public class SpaceWarz {

	public static void main(String[] args) {
		Area area = new Area(10);
		AdmiralSpaceCraft adm = new AdmiralSpaceCraft();
		SpaceHunter hunt = new SpaceHunter();
		SpaceHunter hunt2 = new SpaceHunter();
		SpaceCraft spc = new SpaceCraft();
		SpaceCraft spc2 = new SpaceCraft();
		DeathStar star = new DeathStar();
		Controler controller = new Controler(area);
		area.affiche();
		System.out.println();
		
		controller.putPion(adm, 5, 2);
		controller.putPion(hunt, 2, 4);		
		controller.putPion(hunt2, 0, 8);
		controller.putPion(spc, 1, 1);
		controller.putPion(spc2, 4, 8);
		controller.putPion(star, 7, 6);
		
		area.affiche();
		System.out.println();
		
		controller.resetPlacement();
		controller.putPion(spc, 1, 1);
		controller.putPion(spc2, 4, 8);
		controller.putPion(star, 7, 6);
		
		area.affiche();
		
		/*
		System.out.println("Coordonnée du vaisseau amiral");
		for(int i=0; i<adm.getNbCase(); i++){
			System.out.print(" "+adm.getCase(i).getPosition());
		}
		System.out.println();
		System.out.println("Coordonnée du chasseur spatial");
		for(int i=0; i<hunt.getNbCase(); i++){
			System.out.print(" "+hunt.getCase(i).getPosition());
		}
		*/
		
	}

}
