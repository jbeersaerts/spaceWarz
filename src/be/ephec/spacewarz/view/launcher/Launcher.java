package be.ephec.spacewarz.view.launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import be.ephec.spacewarz.controler.Controler;


/**
 * La classe Launcher représente le launcher de l'application au niveau de l'interface graphique.
 * 
 * La classe est dénuée d'action listeners car ils sont tous gerés par {@link Controler}
 * 
 */
@SuppressWarnings("serial")
public class Launcher extends javax.swing.JFrame{
	
	private JPanel title;
	private JPanel bottom;
	private JPanel gridBagCenter;
	private JPanel borderLeft;
	private JPanel borderRight;
	
	private JButton quitButton;
	private JButton playServerButton;
	private JButton playClientButton;
	
	private static final int nbGridRow = 3;
	private JTextField ipAdv = new JTextField();
	private JTextField numPortServer = new JTextField() ;
	private JLabel tabLabel[] = new JLabel[3]; /* 3 on first column */
	private JList<String> ipList;
	private String strJLabel[] ={
								 "Votre IP :",
								 "IP adversaire :",
								 "N°port serveur"
								 };
	
	
	
	/**
	 * Instantiates a new launcher.
	 */
	public Launcher(){
		

		super("SpaceWarz Launcher");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		/*
		 * 
		 * Title Panel
		 * 
		 */
		this.title = new JPanel();
		this.title.setPreferredSize(new Dimension(250,100));
		JLabel imgTitle = new JLabel("");
		imgTitle.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/title.jpg")));
		this.title.add(imgTitle);
		this.getContentPane().add(this.title,BorderLayout.NORTH);
		
		
		/*
		 * 
		 * Bottom Panel
		 * 
		 */
		this.bottom = new JPanel();
		this.bottom.setPreferredSize(new Dimension(250,50));
		playServerButton = new JButton();
		playServerButton.setText("Jouer (serveur) !");
		playClientButton = new JButton();
		playClientButton.setText("Jouer (client) !");
		quitButton = new JButton();
		quitButton.setText("Quitter");
		
		this.bottom.add(playServerButton);
		this.bottom.add(playClientButton);
		this.bottom.add(quitButton);
		
		this.getContentPane().add(this.bottom,BorderLayout.SOUTH);
		/*
		 * 
		 * Borders left right Panel
		 * 
		 */
		this.borderLeft = new JPanel();
		borderLeft.setPreferredSize(new Dimension(20, 300));
		this.getContentPane().add(this.borderLeft,BorderLayout.WEST);
		
		this.borderRight = new JPanel();
		borderRight.setPreferredSize(new Dimension(20, 300));
		this.getContentPane().add(this.borderRight,BorderLayout.EAST);
		
		
		
		/*
		 * 
		 * Grid Center
		 * 
		 */
		this.gridBagCenter = new JPanel();
		GridBagLayout gridBag = new GridBagLayout();
		gridBag.columnWidths = new int[] {7, 7};
		gridBag.rowHeights = new int[] {7, 7, 7};
		gridBag.columnWeights = new double[] {0.1, 0.1};
		gridBag.rowWeights = new double[] {0.1, 0.1, 0.1};
		gridBagCenter.setLayout(gridBag);
		this.getContentPane().add(gridBagCenter,BorderLayout.CENTER);
			
		/*
		 * 
		 * Put Component on the gridBagPanel
		 * 
		 */
		
			initTabLabelAndJList();
			for(int i = 0;i<nbGridRow;i++){
				gridBagCenter.add(tabLabel[i], new GridBagConstraints(0, i,  1, 1, 0.0, 0.0, 
								  GridBagConstraints.WEST,
								  GridBagConstraints.NONE,
								  new Insets(0, 0, 0, 0), 0, 0));
			}

			gridBagCenter.add(ipList, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							  GridBagConstraints.CENTER,
							  GridBagConstraints.HORIZONTAL,
							  new Insets(0, 0, 0, 0), 0, 0));
			
			gridBagCenter.add(ipAdv, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    										GridBagConstraints.CENTER,
                    										GridBagConstraints.HORIZONTAL,
                    										new Insets(0, 0, 0, 0), 0, 0));

			gridBagCenter.add(numPortServer, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
							  GridBagConstraints.CENTER,
							  GridBagConstraints.HORIZONTAL,
							  new Insets(0, 0, 0, 0), 0, 0));
		
		
		this.setVisible(true);
	}

	
	/**
	 * Inits the tab label and j list.
	 */
	private void initTabLabelAndJList(){
		for(int i=0; i<nbGridRow;i++){
			tabLabel[i] = new JLabel();
			tabLabel[i].setText(strJLabel[i]);
		}
		/*
		 * JList who will contains the IP address of the computer
		 * use INET ADDRESS to get the ip address
		 * 
		 */
		try {
			
			InetAddress tabIPlocal[] = Inet4Address.getAllByName(Inet4Address.getLocalHost().getHostName());
			String strIpAddress[] = new String[tabIPlocal.length];
			for(int i = 0; i< tabIPlocal.length;i++){
				strIpAddress[i] = tabIPlocal[i].toString();
			}
			ListModel<String> ipModel = new DefaultComboBoxModel<String>(strIpAddress);
			//System.out.println(strIpAddress);
			ipList = new JList<String>();
			ipList.setModel(ipModel);
			
		} catch (UnknownHostException e) {
			
		}
		
	}

	
	/**
	 * Gets the quit button.
	 *
	 * @return the quit button
	 */
	public JButton getQuitButton() {
		return quitButton;
	}


	/**
	 * Gets the play server button.
	 *
	 * @return the play server button
	 */
	public JButton getPlayServerButton() {
		return playServerButton;
	}


	/**
	 * Gets the play client button.
	 *
	 * @return the play client button
	 */
	public JButton getPlayClientButton() {
		return playClientButton;
	}


	/**
	 * Gets the ip adv.
	 *
	 * @return the ip adv
	 */
	public JTextField getIpAdv() {
		return ipAdv;
	}
	
	/**
	 * Gets the num port server.
	 *
	 * @return the num port server
	 */
	public JTextField getNumPortServer() {
		return numPortServer;
	}
}
