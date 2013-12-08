package be.ephec.view;

import javax.swing.SwingUtilities;
import be.ephec.view.launcher.Launcher;


public class TestGui {

	@SuppressWarnings("unused")
	public static void main(String[] args) {		
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Launcher win = new Launcher();
				}});

	}

}
