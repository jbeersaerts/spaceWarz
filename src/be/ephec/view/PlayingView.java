package be.ephec.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class PlayingView extends javax.swing.JFrame {
	// Extend JFrame en attendant pour les debug avec JGloo. A remplacer par JWindow
	private JLabel Background;
	private JPanel Quadrillage;
	private JButton Quit;
	private JLabel GrilleJoueur;
	private JLabel GrilleAdversaire;
	private JLabel Spaceship2;
	
	//Movement vars
	private int sX,sY,currentX,currentY;
	private boolean dragging;
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlayingView inst = new PlayingView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PlayingView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		{
			Quadrillage = new JPanel();
getContentPane().add(Quadrillage);
			GridBagLayout GridLayout = new GridBagLayout();
			GridLayout.columnWidths = new int[] {7, 7};
			GridLayout.rowHeights = new int[] {7, 7, 7};
			GridLayout.columnWeights = new double[] {0.1, 0.1};
			GridLayout.rowWeights = new double[] {0.1, 0.1, 0.1};
			Quadrillage.setLayout(GridLayout);
			Quadrillage.setBounds(0, 0, 1000, 800);
			Quadrillage.setOpaque(false);
		}
		{
			Background = new JLabel();
			this.setContentPane(Background);
			Background.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/background_all.png")));
			Background.setSize(1000, 800);
			Background.setBorder(new LineBorder(new java.awt.Color(140,140,140),5, false));
			{
				Spaceship2 = new JLabel();
				Background.add(Spaceship2);
				Spaceship2.setBounds(229, 595, 30, 59);
				Spaceship2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship_2.png")));
				Spaceship2.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent evt) {
						Spaceship2MouseDragged(evt);
					}
				});

			}
			{
				GrilleJoueur = new JLabel();
				Background.add(GrilleJoueur);
				//GrilleJoueur.setSize(348, 354);
				GrilleJoueur.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/grid.png")));
				GrilleJoueur.setBounds(126, 200, 354, 348);
			}
			{
				GrilleAdversaire = new JLabel();
				Background.add(GrilleAdversaire);
				GrilleAdversaire.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/grid.png")));
				GrilleAdversaire.setBounds(520, 200, 354, 348);
			}
			{
				/* GrilleJoueur = new JLabel();
				Grid.add(GrilleJoueur, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				GrilleJoueur.setIcon(new ImageIcon(getClass().getClassLoader().getResource("PNG/grid.png")));
				GrilleJoueur.setSize(354, 348); */
				
				
				
				
				Quit = new JButton();
				Background.add(Quit);
				Quit.setText("Quitter");
				Quit.setBounds(445, 658, 90, 23);
				Quit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dispose();
						System.out.println("La fenêtre a été quittée");
						//TODO add your code for Quit.actionPerformed
					}
				});
			}
		}
		pack();
		//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(1000, 800);

		//getContentPane().add(Background, BorderLayout.CENTER);

	}

	
	
	private void Spaceship2MouseDragged(MouseEvent evt) {
		//System.out.println("Spaceship2.mouseDragged, event="+evt);
		
		Point p = evt.getPoint();
		
		Spaceship2.setLocation(p);
	}

}

