package be.ephec.spacewarz.view;


import javax.swing.JLabel;

/**
 * la classe MyJLabel est une sp�cialisation de la classe {@link JLabel} 
 * � laquelle nous avons ajout� des coordonn�e x et y. Ceci �tant plus 
 * adapt�e � nos besoins pour le placement des grilles de jeux dans 
 * la view ( {@link PlayingView} ). 
 * 
 * @author Olivier Vroman & Jonathan Beersaerts
 *
 */
public class MyJLabels extends JLabel {
	private static final long serialVersionUID = 1L;
	private int line;
	private int column;
	
	public MyJLabels(int line, int column){
		this.line = line;
		this.column = column;
		
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	
	
	
}
