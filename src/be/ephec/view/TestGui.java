package be.ephec.view;

import javax.swing.SwingUtilities;


public class TestGui {

	@SuppressWarnings("unused")
	public static void main(String[] args) {		
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					LauncherWindow win = new LauncherWindow();
				}
			});

	}

}
