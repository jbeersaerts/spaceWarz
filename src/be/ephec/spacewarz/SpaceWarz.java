package be.ephec.spacewarz;

import javax.swing.SwingUtilities;
import be.ephec.spacewarz.controler.Controler;
import be.ephec.spacewarz.model.area.Area;
import be.ephec.spacewarz.model.pions.AdmiralSpaceCraft;
import be.ephec.spacewarz.model.pions.DeathStar;
import be.ephec.spacewarz.model.pions.SpaceCraft;
import be.ephec.spacewarz.model.pions.SpaceHunter;
import be.ephec.spacewarz.view.PlayingView;
import be.ephec.spacewarz.view.launcher.Launcher;

/**
 * The Class SpaceWarz is the main of the Game.
 * 
 */
public class SpaceWarz {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Area area = new Area(10);
				AdmiralSpaceCraft adm = new AdmiralSpaceCraft();
				SpaceHunter hunt1 = new SpaceHunter();
				SpaceHunter hunt2 = new SpaceHunter();
				SpaceCraft spc1 = new SpaceCraft();
				SpaceCraft spc2 = new SpaceCraft();
				DeathStar star = new DeathStar();
				Launcher launch = new Launcher();
				PlayingView gamingView = new PlayingView();
				gamingView.setVisible(false);
				@SuppressWarnings("unused")
				Controler controler = new Controler(area, new Area(10), adm, star, spc1, spc2, hunt1, hunt2, gamingView,launch);
				gamingView.setLocationRelativeTo(null);
				
			}
		});
	}
	
}