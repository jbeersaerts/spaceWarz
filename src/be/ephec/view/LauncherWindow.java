package be.ephec.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class LauncherWindow extends javax.swing.JFrame{
	private JPanel title;
	private JPanel bottom;
	private JPanel gridBagCenter;
	private JPanel borderLeft;
	private JPanel borderRight;
	
	private static final int nbGridRow = 3;
	
	private JTextField ipAdv = new JTextField();
	private JTextField name = new JTextField();
	
	private JLabel tabLabel[] = new JLabel[4]; /* 3 on first column and one on second */
	private String strJLabel[] ={
								 "Nom : ",
								 "Votre IP :",
								 "IP adversaire :"
								 };
	
	
	
	public LauncherWindow(){
		super("My Windows");
		this.setSize(460, 360);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.title = new JPanel();
		this.title.setPreferredSize(new Dimension(250,100));
		JLabel imgTitle = new JLabel("");
		imgTitle.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/title.jpg")));
		this.title.add(imgTitle);
		this.getContentPane().add(this.title,BorderLayout.NORTH);
		
		this.bottom = new JPanel();
		this.bottom.setPreferredSize(new Dimension(250,50));
		JButton playButton = new JButton();
		JButton quitButton = new JButton();
		playButton.setText("Jouer !");
		quitButton.setText("Quitter");
		this.bottom.add(playButton);
		this.bottom.add(quitButton);
		this.getContentPane().add(this.bottom,BorderLayout.SOUTH);
		
		this.borderLeft = new JPanel();
		borderLeft.setPreferredSize(new Dimension(20, 300));
		this.getContentPane().add(this.borderLeft,BorderLayout.WEST);
		
		this.borderRight = new JPanel();
		borderRight.setPreferredSize(new Dimension(20, 300));
		this.getContentPane().add(this.borderRight,BorderLayout.EAST);
		
		
		this.gridBagCenter = new JPanel();
		GridBagLayout gridBag = new GridBagLayout();
		gridBag.columnWidths = new int[] {7, 7};
		gridBag.rowHeights = new int[] {7, 7, 7};
		gridBag.columnWeights = new double[] {0.1, 0.1};
		gridBag.rowWeights = new double[] {0.1, 0.1, 0.1};
		gridBagCenter.setLayout(gridBag);
		this.getContentPane().add(gridBagCenter,BorderLayout.CENTER);
			
		/*
		 * Put Component on the gridBagPanel
		 */
		
			initTabLabel();
			for(int i = 0;i<nbGridRow;i++){
				gridBagCenter.add(tabLabel[i], new GridBagConstraints(0, i,  1, 1, 0.0, 0.0, 
																		GridBagConstraints.WEST,
																		GridBagConstraints.NONE,
																		new Insets(0, 0, 0, 0), 0, 0));
			}
			gridBagCenter.add(name, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					                                       GridBagConstraints.CENTER,
					                                       GridBagConstraints.HORIZONTAL,
					                                       new Insets(0, 0, 0, 0), 0, 0));

			gridBagCenter.add(ipAdv, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    										GridBagConstraints.CENTER,
                    										GridBagConstraints.HORIZONTAL,
                    										new Insets(0, 0, 0, 0), 0, 0));
			gridBagCenter.add(tabLabel[3], new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
																	GridBagConstraints.CENTER,
																	GridBagConstraints.BOTH,
																	new Insets(0, 0, 0, 0), 0, 0));
		
		
		this.setVisible(true);
	}

	
	private void initTabLabel(){
		for(int i=0; i<3;i++){
			tabLabel[i] = new JLabel();
			tabLabel[i].setText(strJLabel[i]);
		}
		/*
		 * init the last wich will contains the IP address of the computer
		 * Should use INET ADDRESS to get the ip address
		 * 
		 */
		tabLabel[3] = new JLabel();
		tabLabel[3].setText("example : 192.168.xx.xx");
		
	}

}
