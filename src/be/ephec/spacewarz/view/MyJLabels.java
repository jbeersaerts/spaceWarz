package be.ephec.spacewarz.view;


import javax.swing.JLabel;

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
