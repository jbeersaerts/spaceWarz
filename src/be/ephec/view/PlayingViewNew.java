package be.ephec.view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import be.ephec.controler.Controler;
import be.ephec.model.pions.AdmiralSpaceCraft;
import be.ephec.model.pions.DeathStar;
import be.ephec.model.pions.SpaceCraft;
import be.ephec.model.pions.SpaceHunter;


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

@SuppressWarnings("serial")
public class PlayingViewNew extends javax.swing.JFrame {
	// Extend JFrame en attendant pour les debug avec JGloo. A remplacer par JWindow
	private final int L = 10;
	private final int C = 10;
	private JLabel Background;
	private JButton Quit;
	private JButton Reset;
	private JLabel GrilleJoueur;
	private JLabel GrilleAdversaire;
	private JPanel player_responsive_grid;
	private JPanel opponent_responsive_grid;
	private JLabel tabJLabels[][] = new MyJLabels[L][C];
	private JLabel tabJLabels2[][] = new MyJLabels[L][C];
	private JPanel vaisseaux_panel;
	private JLabel tabVaisseaux[][] = new MyJLabels[1][4];
	private JLabel textVaisseaux;
	private int choice = -1;

	
	/*
	 * add by jon
	 */

	private Controler controler;
	private AdmiralSpaceCraft adm;
	private SpaceHunter hunt;
	private SpaceHunter hunt2;
	private SpaceCraft spc;
	private SpaceCraft spc2;
	private DeathStar star;
	
	/**
	* Auto-generated main method to display this JFrame
	*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlayingView inst = new PlayingView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*
	*/
	
	public PlayingViewNew(Controler controler, AdmiralSpaceCraft adm, SpaceHunter hunt,
					   SpaceHunter hunt2, SpaceCraft spc, SpaceCraft spc2, DeathStar star) {
		super();
		this.controler = controler;
		this.adm = adm;
		this.hunt = hunt;
		this.hunt2 = hunt2;
		this.spc = spc;
		this.spc2 = spc2;
		this.star = star;
		initGUI();
	}
	
	private void initGUI() {

		{
			Background = new JLabel();
			this.setContentPane(Background);
			Background.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/background_all.png")));
			Background.setSize(1000, 800);
			Background.setBorder(new LineBorder(new java.awt.Color(140,140,140),5, false));
			{
				GrilleJoueur = new JLabel();
				Background.add(GrilleJoueur);
				GrilleJoueur.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/grid.png")));
				GrilleJoueur.setBounds(126, 90, 354, 348);
			}
			{
				GrilleAdversaire = new JLabel();
				Background.add(GrilleAdversaire);
				GrilleAdversaire.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/grid.png")));
				GrilleAdversaire.setBounds(520, 90, 354, 348);
			}
			// Grille réactive du joueur
			{
				player_responsive_grid = new JPanel();
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
				jPanel1Layout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
				jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				Background.add(player_responsive_grid);
				player_responsive_grid.setLayout(jPanel1Layout);
				player_responsive_grid.setBounds(159, 118, 310, 310);
				{
					for(int l=0;l<L;l++)
						for(int c=0;c<C;c++)
						{
							tabJLabels[l][c] = new MyJLabels(l,c);
							//tabJLabels[l][c].setBackground(Color.green);
							tabJLabels[l][c].setOpaque(true);
							//tabJLabels[l][c].setSize(new Dimension(10, 10));
							tabJLabels[l][c].setPreferredSize(new Dimension(29, 29));
							player_responsive_grid.add(tabJLabels[l][c], new GridBagConstraints(l,c, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							tabJLabels[l][c].addMouseListener(new MouseAdapter() {
								public void mouseEntered(MouseEvent evt) {
									jLabelMouseEntered(evt);
								}
							});
							tabJLabels[l][c].addMouseListener(new MouseAdapter() {
								public void mouseExited(MouseEvent evt) {
									jLabelMouseExited(evt);
								}
							});
							tabJLabels[l][c].addMouseListener(new MouseAdapter() {
								public void mousePressed(MouseEvent evt) {
									jLabelMousePressed(evt);
								}
							});
						
						}
				}
			}
			// Grille réactive de l'opposant
			{
				opponent_responsive_grid = new JPanel();
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
				jPanel1Layout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
				jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				Background.add(opponent_responsive_grid);
				opponent_responsive_grid.setLayout(jPanel1Layout);
				opponent_responsive_grid.setBounds(553, 118, 310, 310);
				{
					for(int l=0;l<L;l++)
						for(int c=0;c<C;c++)
						{
							tabJLabels2[l][c] = new MyJLabels(l,c);
							//tabJLabels[l][c].setBackground(Color.green);
							tabJLabels2[l][c].setOpaque(true);
							//tabJLabels[l][c].setSize(new Dimension(10, 10));
							tabJLabels2[l][c].setPreferredSize(new Dimension(29, 29));
							opponent_responsive_grid.add(tabJLabels2[l][c], new GridBagConstraints(l,c, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							tabJLabels2[l][c].addMouseListener(new MouseAdapter() {
								public void mouseEntered(MouseEvent evt) {
									jLabelMouseEntered(evt);
								}
							});
							tabJLabels2[l][c].addMouseListener(new MouseAdapter() {
								public void mouseExited(MouseEvent evt) {
									jLabelMouseExited(evt);
								}
							});
							tabJLabels2[l][c].addMouseListener(new MouseAdapter() {
								public void mousePressed(MouseEvent evt) {
									fire(evt);
								}
							});
						}
				}
			}
			// Panel des bateaux du jeu
			{
				vaisseaux_panel = new JPanel();
				GridBagLayout VaisseauxLayout = new GridBagLayout();
				VaisseauxLayout.columnWidths = new int[]{7,7,7,7};
				VaisseauxLayout.rowHeights = new int[]{7,7,7};
				VaisseauxLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				VaisseauxLayout.rowWeights = new double[]{0.1,0.1,0.1};
				Background.add(vaisseaux_panel);
				vaisseaux_panel.setLayout(VaisseauxLayout);
				vaisseaux_panel.setBounds(126, 446, 464, 100);
				vaisseaux_panel.setOpaque(false);
				{
					textVaisseaux = new JLabel();
					textVaisseaux.setText("<html><font size= 4  color= #eda709 ><b>Vaisseaux disponible dans ce jeu :</b></font></html>");
					vaisseaux_panel.add(textVaisseaux, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					for(int i=0;i<4;i++) {
						tabVaisseaux[0][i] = new MyJLabels(0,i);
						tabVaisseaux[0][i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship_"+(i+2)+".png")));
						vaisseaux_panel.add(tabVaisseaux[0][i], new GridBagConstraints(i, 1, 1, 1, 0.0,0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						tabVaisseaux[0][i].addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent evt){
								tabVaisseauxMousePressed(evt);
							}
						});	
					}
				}
			}
			// Bouton Reset
			{
				Reset = new JButton();
				Background.add(Reset);
				Reset.setText("Reset");
				Reset.setBounds(375, 445, 90, 23);
				Reset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						resetSpaceships();
					}
				});
			}
			// Bouton Quitter
			{
				Quit = new JButton();
				Background.add(Quit);
				Quit.setText("Quitter");
				Quit.setBounds(445, 685, 90, 23);
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

	private void jLabelMouseEntered(MouseEvent evt) {
		((MyJLabels)evt.getSource()).setBackground(new java.awt.Color(216,227,235));
		((MyJLabels)evt.getSource()).setOpaque(true);
	}
	private void jLabelMouseExited(MouseEvent evt) {
		((MyJLabels)evt.getSource()).setBackground(new java.awt.Color(247,247,247));
		((MyJLabels)evt.getSource()).setOpaque(true);
	}
	private void jLabelMousePressed(MouseEvent evt) {
		int l = ((MyJLabels)evt.getSource()).getLine();
		int c = ((MyJLabels)evt.getSource()).getColumn();
		switch(choice){
		case 0 :
			if(SpaceHunter.getNbInstance()==0){
				if(controler.putPion(hunt, l, c)==0){
					tabJLabels[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_1.png")));
					tabJLabels[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_2.png")));
					System.out.println("hunt :"+hunt.getCase(0));
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else if(SpaceHunter.getNbInstance() == 1){
				if(controler.putPion(hunt2, l, c)==0){
					tabJLabels[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_1.png")));
					tabJLabels[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_2.png")));
					System.out.println("hunt2 :"+hunt2.getCase(0));
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			break;
		case 1 : 
			if(SpaceCraft.getNbInstance()== 0){
				if(controler.putPion(spc, l, c) == 0){
					tabJLabels[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_1.png")));
					tabJLabels[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_2.png")));
					tabJLabels[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_3.png")));
					System.out.println("spcCraft "+spc.getCase(0));
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else if(SpaceCraft.getNbInstance() == 1){
				if(controler.putPion(spc2, l, c) == 0){
					tabJLabels[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_1.png")));
					tabJLabels[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_2.png")));
					tabJLabels[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_3.png")));
					System.out.println("spcCraft2 "+spc2.getCase(0));
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			
			break;
		case 2 :
			if(AdmiralSpaceCraft.getNbInstance() == 0){
				if(controler.putPion(adm, l, c) == 0){
					tabJLabels[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_1.png")));
					tabJLabels[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_2.png")));
					tabJLabels[l+2][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_3.png")));
					tabJLabels[l+3][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_4.png")));
					System.out.println("adm = "+adm.getCase(0));
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			break;
		case 3 :
			if(DeathStar.getNbInstance() == 0){
				if(controler.putPion(star, l, c) == 0){
					tabJLabels[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_1.png")));
					tabJLabels[l-1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_2.png")));
					tabJLabels[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_3.png")));
					tabJLabels[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_4.png")));
					tabJLabels[l][c-1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_5.png")));
					System.out.println("star = "+star.getCase(0));
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			break;
		}
	}
	private void tabVaisseauxMousePressed(MouseEvent evt1){
		int c = ((MyJLabels)evt1.getSource()).getColumn();
		choice = c;
	}
	
	// FIRE
	
	private void fire(MouseEvent evt){
		int l = ((MyJLabels)evt.getSource()).getLine();
		int c = ((MyJLabels)evt.getSource()).getColumn();
		
		
		if(controler.fireOnCase(c, l)!=null) {
			tabJLabels2[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/touched.png")));
			controler.fireOnCase(l, c).isTouch();
		}
		else{
			System.out.println("Dans l'eau !");
			tabJLabels2[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/plouf.png")));
		}
			
		
	}
	
	// reset
	private void resetSpaceships(){
		if(JOptionPane.showConfirmDialog(Background, "Etes vous sûr de vouloir réinitialiser la position de tous les vaisseaux ?")==0) {
			for(int c=0;c<C;c++)
				for(int l=0;l<L;l++){
					tabJLabels[l][c].setIcon(null);
				}
			controler.resetPlacement();
			SpaceHunter.setNbInstance(0);
			SpaceCraft.setNbInstance(0);
			AdmiralSpaceCraft.setNbInstance(0);
			DeathStar.setNbInstance(0);			
		}
		
		

	}


	
}

