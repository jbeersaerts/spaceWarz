package be.ephec.spacewarz.view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import be.ephec.spacewarz.view.listener.HoveringLabelListener;
import be.ephec.spacewarz.view.MyJLabels;


@SuppressWarnings("serial")
public class PlayingView extends javax.swing.JFrame {
	
	

	
	private final int L = 10;
	private final int C = 10;
	
	private JLabel backgroundLabel;

	private JLabel playerGrid;
	private JPanel player_responsive_grid;
	private JLabel tabPlayerLabel[][] = new MyJLabels[L][C];
	
	private JLabel opponentGrid;
	private JPanel opponent_responsive_grid;
	private JLabel tabOpponentLabel[][] = new MyJLabels[L][C];
	
	private JPanel vaisseaux_panel;
	private JLabel tabVaisseaux[][] = new MyJLabels[1][4];
	private JLabel textVaisseaux;
	
	private JButton quitButton;
	private JButton resetButton;
	private JButton readyButton;

	
	public PlayingView() {
		super();
		initGUI();
	}
	
	private void initGUI() {

		{
			/*
			 * 
			 * 
			 * Background and other label and panel
			 * 
			 * 
			 */
			backgroundLabel = new JLabel();
			this.setContentPane(backgroundLabel);
			backgroundLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/background_all1.png")));
			backgroundLabel.setSize(1000, 600);
			backgroundLabel.setBorder(new LineBorder(new java.awt.Color(140,140,140),5, false));
			{
				playerGrid = new JLabel();
				backgroundLabel.add(playerGrid);
				playerGrid.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/grid.png")));
				playerGrid.setBounds(126, 90, 354, 348);
			}
			{
				opponentGrid = new JLabel();
				backgroundLabel.add(opponentGrid);
				opponentGrid.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/grid.png")));
				opponentGrid.setBounds(520, 90, 354, 348);
			}
			
			
			
			/*
			 * 
			 * 
			 * Player Responsive Grid
			 * 
			 * 
			 */
			player_responsive_grid = new JPanel();
			GridBagLayout playerGridLayout = new GridBagLayout();
			playerGridLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
			playerGridLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
			playerGridLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
			playerGridLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
			backgroundLabel.add(player_responsive_grid);
			player_responsive_grid.setLayout(playerGridLayout);
			player_responsive_grid.setBounds(159, 118, 310, 310);
			
			for(int l=0;l<L;l++){
					
				for(int c=0;c<C;c++){
					tabPlayerLabel[l][c] = new MyJLabels(l,c);
					tabPlayerLabel[l][c].setOpaque(true);
					tabPlayerLabel[l][c].setPreferredSize(new Dimension(29, 29));
					player_responsive_grid.add(tabPlayerLabel[l][c], 
											    new GridBagConstraints(l,c, 1, 1, 0.0, 0.0,
											    GridBagConstraints.CENTER, 
											    GridBagConstraints.NONE, 
											    new Insets(0, 0, 0, 0), 0, 0));		
					tabPlayerLabel[l][c].addMouseListener(new HoveringLabelListener());
				} 
				/*end of second for*/
			} 
			/* end of first for */
			
			
			
			
			/*
			 * 
			 * 
			 * Opponent Responsive Grid
			 * 
			 * 
			 */
			opponent_responsive_grid = new JPanel();
			GridBagLayout opponentGridLayout = new GridBagLayout();
			opponentGridLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
			opponentGridLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
			opponentGridLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
			opponentGridLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
			backgroundLabel.add(opponent_responsive_grid);
			opponent_responsive_grid.setLayout(opponentGridLayout);
			opponent_responsive_grid.setBounds(553, 118, 310, 310);
			for(int l=0;l<L;l++){	
				for(int c=0;c<C;c++)
				{
					tabOpponentLabel[l][c] = new MyJLabels(l,c);
					tabOpponentLabel[l][c].setOpaque(true);
					tabOpponentLabel[l][c].setPreferredSize(new Dimension(29, 29));
					opponent_responsive_grid.add(tabOpponentLabel[l][c], 
												 new GridBagConstraints(l,c, 1, 1, 0.0, 0.0, 
												 GridBagConstraints.CENTER, 
												 GridBagConstraints.NONE, 
												 new Insets(0, 0, 0, 0), 0, 0));	
					tabOpponentLabel[l][c].addMouseListener(new HoveringLabelListener());
					/*
					 * 
					tabOpponentLabel[l][c].addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent evt) {
							fire(evt);
						}
					});
					*/
				}
			}
				
			
			
			
			
			
			/*
			 * 
			 * 
			 * Panel des vaisseaux disponible
			 * 
			 * 
			 */
			vaisseaux_panel = new JPanel();
			GridBagLayout VaisseauxLayout = new GridBagLayout();
			VaisseauxLayout.columnWidths = new int[]{7,7,7,7};
			VaisseauxLayout.rowHeights = new int[]{7,7,7};
			VaisseauxLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			VaisseauxLayout.rowWeights = new double[]{0.1,0.1,0.1};
			backgroundLabel.add(vaisseaux_panel);
			vaisseaux_panel.setLayout(VaisseauxLayout);
			vaisseaux_panel.setBounds(126, 446, 464, 100);
			vaisseaux_panel.setOpaque(false);
			{
				textVaisseaux = new JLabel();
				textVaisseaux.setText("<html><font size= 4  color= #eda709 ><b>Vaisseaux disponibles :</b></font></html>");
				vaisseaux_panel.add(textVaisseaux, 
									new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0, 
									GridBagConstraints.CENTER, 
									GridBagConstraints.BOTH, 
									new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				for(int i=0;i<4;i++) {
					tabVaisseaux[0][i] = new MyJLabels(0,i);
					tabVaisseaux[0][i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship_"+(i+2)+".png")));
					vaisseaux_panel.add(tabVaisseaux[0][i], 
										new GridBagConstraints(i, 1, 1, 1, 0.0,0.0, 
										GridBagConstraints.CENTER, 
										GridBagConstraints.BOTH, 
										new Insets(0, 0, 0, 0), 0, 0));
				}
			}
	
			
			
			/*
			 * 
			 * 
			 * Reset Button
			 * 
			 * 
			 */
			resetButton = new JButton();
			backgroundLabel.add(resetButton);
			resetButton.setText("Reset");
			resetButton.setBounds(285, 445, 90, 23);

			/*
			 * 
			 * Ready Button
			 * 
			 */
			readyButton = new JButton();
			backgroundLabel.add(readyButton);
			readyButton.setText("Prêt !");
			readyButton.setBounds(395, 445, 90, 23);
			
			/*
			 * 
			 * 
			 * Quit Button
			 * 
			 * 
			 */
			quitButton = new JButton();
			backgroundLabel.add(quitButton);
			quitButton.setText("Quitter");
			quitButton.setBounds(645, 550, 90, 23);
		}
		this.pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1025, 640);
	}


	
	
	public JLabel getBackgroundLabel() {
		return backgroundLabel;
	}


	public JLabel[][] getTabPlayerLabel() {
		return tabPlayerLabel;
	}


	public JLabel[][] getTabOpponentLabel() {
		return tabOpponentLabel;
	}


	public JLabel[][] getTabVaisseaux() {
		return tabVaisseaux;
	}


	public JButton getQuitButton() {
		return quitButton;
	}


	public JButton getResetButton() {
		return resetButton;
	}
	
	public JButton getReadyButton() {
		return readyButton; 
	}


	public int getL() {
		return L;
	}


	public int getC() {
		return C;
	}
	
	
}

