package be.ephec.spacewarz;

import javax.swing.SwingUtilities;

import be.ephec.controler.Controler;
import be.ephec.model.area.Area;
import be.ephec.model.pions.AdmiralSpaceCraft;
import be.ephec.model.pions.DeathStar;
import be.ephec.model.pions.SpaceCraft;
import be.ephec.model.pions.SpaceHunter;
import be.ephec.view.PlayingViewNew;

public class SpaceWarz {

	public static void main(String[] args) {
		
		/*
		Area area = new Area(10);
		AdmiralSpaceCraft adm = new AdmiralSpaceCraft();
		SpaceHunter hunt = new SpaceHunter();
		SpaceHunter hunt2 = new SpaceHunter();
		SpaceCraft spc = new SpaceCraft();
		SpaceCraft spc2 = new SpaceCraft();
		DeathStar star = new DeathStar();
		Controler controler = new Controler(area);
		*/
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Area area = new Area(10);
				AdmiralSpaceCraft adm = new AdmiralSpaceCraft();
				SpaceHunter hunt = new SpaceHunter();
				SpaceHunter hunt2 = new SpaceHunter();
				SpaceCraft spc = new SpaceCraft();
				SpaceCraft spc2 = new SpaceCraft();
				DeathStar star = new DeathStar();
				Controler controler = new Controler(area);
				PlayingViewNew inst = new PlayingViewNew(controler,adm,hunt,hunt2,spc,spc2,star);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
		
		/*
		//area.affiche();
		//System.out.println();
		
		controler.putPion(adm, 5, 2);
		controler.putPion(hunt, 2, 4);		
		controler.putPion(hunt2, 8, 8);
		controler.putPion(spc, 0, 0);
		controler.putPion(spc2, 0, 8);
		controler.putPion(star, 7, 6);
		
		area.affiche();
		*/
		
	}
	
}