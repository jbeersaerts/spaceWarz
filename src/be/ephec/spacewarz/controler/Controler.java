package be.ephec.spacewarz.controler;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import be.ephec.spacewarz.model.area.Area;
import be.ephec.spacewarz.model.area.Coord;
import be.ephec.spacewarz.model.pions.AdmiralSpaceCraft;
import be.ephec.spacewarz.model.pions.DeathStar;
import be.ephec.spacewarz.model.pions.Pion;
import be.ephec.spacewarz.model.pions.SpaceCraft;
import be.ephec.spacewarz.model.pions.SpaceHunter;
import be.ephec.spacewarz.model.net.Client;
import be.ephec.spacewarz.model.net.Server;
import be.ephec.spacewarz.view.MyJLabels;
import be.ephec.spacewarz.view.PlayingView;
import be.ephec.spacewarz.view.launcher.Launcher;


// TODO: Auto-generated Javadoc
/**
 * The Class Controler.
 */
public class Controler {
	
	/* DEBUG */
	private boolean debug = true; /* change true to see debug line */
	
	/*Model component*/
	private Area gameArea;
	private Area opponentArea;
	
	private AdmiralSpaceCraft adm;
	private DeathStar star;
	private SpaceCraft spc1;
	private SpaceCraft spc2;
	private SpaceHunter hunt1;
	private SpaceHunter hunt2;
	private int spaceshipCounter = 0;
	
	/*View component*/
	private PlayingView gamingView;
	private Launcher gameLauncher;
	private int choice = -1;
	
	/*Controler fields*/
	private boolean gameReady = false;
	private boolean isServer;
	private String ipAdv;
	private int nbVieTotal; // variable qui servira � savoir o� on en est dans la partie
	private int nbVieAdvers; // pour savoir quand on gagne
	
	/* Socket */
	private Server server = null;
	private Client client = null;
	
	/* Fire Variable */
	
	private Coord myTarget; // where I shoot
	private Coord opponentTarget; // Where the opponent shoot
	

	
	
	
	
	/**
	 * Instantiates a new controler.
	 *
	 * @param gameArea the game area
	 * @param opponentArea the opponent area
	 * @param adm the adm
	 * @param star the star
	 * @param spc1 the spc1
	 * @param spc2 the spc2
	 * @param hunt1 the hunt1
	 * @param hunt2 the hunt2
	 * @param gamingView the gaming view
	 * @param gameLauncher the game launcher
	 */
	public Controler(Area gameArea, Area opponentArea, AdmiralSpaceCraft adm,
			DeathStar star, SpaceCraft spc1, SpaceCraft spc2,
			SpaceHunter hunt1, SpaceHunter hunt2, PlayingView gamingView,
			Launcher gameLauncher) {
		super();
		this.gameArea = gameArea;
		this.opponentArea = opponentArea;
		this.adm = adm;
		this.star = star;
		this.spc1 = spc1;
		this.spc2 = spc2;
		this.hunt1 = hunt1;
		this.hunt2 = hunt2;
		this.gamingView = gamingView;
		this.gameLauncher = gameLauncher;
		addListenersOnView();
	}

	/**
	 * Put the specialised Pion on the gameArea at the given position.
	 *
	 * @param x x position
	 * @param y y position
	 * @return Return 0 if the placement is OK or -1 if it's not possible to place the Pion at given position.
	 */
	
	
	private int putAdmiralSpaceCraft( int x, int y){
		if(AdmiralSpaceCraft.getNbInstance() == 1) return -1;
		if(x > gameArea.getSide()-4) return -1;
		for(int i = x; i<x+4; i++){
			if(gameArea.getCase(i, y).isCannotBeUsed() == true && 
			   gameArea.getCase(i, y).getUsedBy() != null) return -1;
		}
		for(int i = x, j = 0; i<x+4; i++, j++){
			gameArea.getCase(i, y).setUsedBy(adm);
			gameArea.getCase(i ,y).setCannotBeUsed(true);
			adm.setCase(gameArea.getCase(i, y), j);
		}
		AdmiralSpaceCraft.setNbInstance(AdmiralSpaceCraft.getNbInstance()+1);
		nbVieTotal = nbVieTotal+4;
		return 0;
	}
	
	
	
	/**
	 * Put the specialised Pion on the gameArea at the given position.
	 *
	 * @param x x position
	 * @param y y position
	 * @return Return 0 if the placement is OK or -1 if it's not possible to place the Pion at given position.
	 */
	private int putSpaceHunter(int x, int y){
		if(SpaceHunter.getNbInstance() == 2) return -1;
		if(y > gameArea.getSide()-2) return -1;
		for(int i = y;i<y+2;i++){
			if(gameArea.getCase(x, i).isCannotBeUsed() == true && 
			   gameArea.getCase(x, i).getUsedBy() != null) return -1;
		}
		for(int i = y, j = 0; i<y+2; i++, j++){
			if(SpaceHunter.getNbInstance()== 0){
				gameArea.getCase(x, i).setUsedBy(hunt1);
				gameArea.getCase(x ,i).setCannotBeUsed(true);
				hunt1.setCase(gameArea.getCase(x, i), j);
			}
			else{
				gameArea.getCase(x, i).setUsedBy(hunt2);
				gameArea.getCase(x ,i).setCannotBeUsed(true);
				hunt2.setCase(gameArea.getCase(x, i), j);
			}
		}
		SpaceHunter.setNbInstance(SpaceHunter.getNbInstance()+1);
		nbVieTotal = nbVieTotal+2;
		return 0;
	}
	
	

	/**
	 * Put the specialised Pion on the gameArea at the given position.
	 *
	 * @param x x position
	 * @param y y position
	 * @return Return 0 if the placement is OK or -1 if it's not possible to place the Pion at given position.
	 */
	private int putSpaceCraft(int x, int y){
		if(SpaceCraft.getNbInstance() == 2) return -1;
		if(x<0 || x > gameArea.getSide()-2) return -1;
		if(y<0 || y > gameArea.getSide()-2) return -1;
		if(gameArea.getCase(x, y).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y).getUsedBy() != null) return -1;
		if(gameArea.getCase(x+1, y).isCannotBeUsed() == true && 
		   gameArea.getCase(x+1, y).getUsedBy() != null) return -1;
		if(gameArea.getCase(x, y+1).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y+1).getUsedBy() != null) return -1;
		
		if(SpaceCraft.getNbInstance() == 0){
			gameArea.getCase(x, y).setUsedBy(spc1);
			gameArea.getCase(x ,y).setCannotBeUsed(true);
			spc1.setCase(gameArea.getCase(x, y), 0);
	
			gameArea.getCase(x+1, y).setUsedBy(spc1);
			gameArea.getCase(x+1 ,y).setCannotBeUsed(true);
			spc1.setCase(gameArea.getCase(x+1, y), 1);
	
			gameArea.getCase(x, y+1).setUsedBy(spc1);
			gameArea.getCase(x ,y+1).setCannotBeUsed(true);
			spc1.setCase(gameArea.getCase(x, y+1), 2);
		}
		else{
			gameArea.getCase(x, y).setUsedBy(spc2);
			gameArea.getCase(x ,y).setCannotBeUsed(true);
			spc2.setCase(gameArea.getCase(x, y), 0);
	
			gameArea.getCase(x+1, y).setUsedBy(spc2);
			gameArea.getCase(x+1 ,y).setCannotBeUsed(true);
			spc2.setCase(gameArea.getCase(x+1, y), 1);
	
			gameArea.getCase(x, y+1).setUsedBy(spc2);
			gameArea.getCase(x ,y+1).setCannotBeUsed(true);
			spc2.setCase(gameArea.getCase(x, y+1), 2);
		}
		SpaceCraft.setNbInstance(SpaceCraft.getNbInstance()+1);
		nbVieTotal = nbVieTotal+3;
		return 0;
	}
	
	
	
	
	/**
	 * Put the specialised Pion on the gameArea at the given position.
	 *
	 * @param x x position
	 * @param y y position
	 * @return Return 0 if the placement is OK or -1 if it's not possible to place the Pion at given position.
	 */
	private int putDeathStar(int x, int y){
		if(DeathStar.getNbInstance() == 1) return -1;
		if(x<1 || x > gameArea.getSide()-2) return -1;
		if(y<1 || y > gameArea.getSide()-2) return -1;
		for(int i = x-1; i < x+2 ; i++){
			if(gameArea.getCase(i, y).isCannotBeUsed() == true && 
			   gameArea.getCase(i, y).getUsedBy() != null) return -1;
		}
		if(gameArea.getCase(x, y-1).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y-1).getUsedBy() != null) return -1;
		if(gameArea.getCase(x, y+1).isCannotBeUsed() == true && 
		   gameArea.getCase(x, y+1).getUsedBy() != null) return -1;

		for(int i = x-1, j = 0; i < x+2 ; i++, j++){
			gameArea.getCase(i, y).setUsedBy(star);
			gameArea.getCase(i ,y).setCannotBeUsed(true);
			star.setCase(gameArea.getCase(i, y), j);
		}
		gameArea.getCase(x, y-1).setUsedBy(star);
		gameArea.getCase(x ,y-1).setCannotBeUsed(true);
		star.setCase(gameArea.getCase(x, y-1), 3);
		
		gameArea.getCase(x, y+1).setUsedBy(star);
		gameArea.getCase(x ,y+1).setCannotBeUsed(true);
		star.setCase(gameArea.getCase(x, y+1), 4);
		
		DeathStar.setNbInstance(DeathStar.getNbInstance()+1);
		nbVieTotal = nbVieTotal+5;
		return 0;
	}
	

	
	
	/**
	 * M�thode v�rifiant si un tir � touch� un vaisseau � la coordonn�e donn�e.
	 *
	 * @param x position d'abscisse
	 * @param y position d'ordonn�e
	 * @return Le pion qui a �t� touch� ou null si ce n'est pas touch�
	 */
	private Pion fireOnCase(int x, int y){
		
			
		// verifie si la coord recue est utilis�e
		if(gameArea.getCase(x, y).getUsedBy() != null){
			gameArea.getCase(x, y).getUsedBy().isShooted();
			gameArea.getCase(x, y).setTouch(true);
			return gameArea.getCase(x, y).getUsedBy();
		}
		gameArea.getCase(x, y).setTouch(true);
		return null;
	}
	
	/**
	 * M�thode de modifiaction de l'image d'une case lorsqu'il y a eu un tir dessus. 
	 *
	 * @param joueur : <code>true</code> pour la grille du joueur, <code>false</code> pour la grille de l'adversaire
	 * @param coord : la coordonn�e de tir
	 * @param touch : <code>true</code> si touch�, <code>false</code> si dans l'eau
	 */
	private void modifyImage(boolean joueur, Coord coord, boolean touch){
		int l = coord.getX(); // R�cup�re la ligne et la colonne de l'image � modifier
		int c = coord.getY();
		if(joueur){
			if(touch) gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship_touched.png")));
			else gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/plouf.png")));
		} else {
			if(touch) gamingView.getTabOpponentLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship_touched.png")));
			else gamingView.getTabOpponentLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/plouf.png")));
		}	
	}
	
	
	/**
	 * M�thode permettant de r�initialiser le placement des vaisseaux dans l'Area
	 * au niveau du mod�le.
	 */
	private void resetPlacement(){
		for(int i = 0; i<gameArea.getSide();i++){
			for(int j = 0; j<gameArea.getSide();j++){
				gameArea.getCase(i, j).setUsedBy(null);
				gameArea.getCase(i, j).setCannotBeUsed(false);
				nbVieTotal=0;
			}
		}
	}
	


	
	


	
	/**
	 * M�thode qui va ajouter tous les listeners necessaire au fonctionnement du programme 
	 * sur la {@link PlayingView} et le {@link Launcher}.
	 * 
	 */
	private void addListenersOnView(){
		
		/*
		 * PlayingView Listeners
		 */
		gamingView.getQuitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitGameEvent(e);
			}
		});
		
		gamingView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetSpaceships();
			}
		});
		
		gamingView.getReadyButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readyEvent(e);
			}
		});
		
		for(int i=0;i<4;i++){
			gamingView.getTabVaisseaux()[0][i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent evt){
					selectCraftEvent(evt);
				}});
		}
		
		for(int l=0;l<gamingView.getL();l++){
			
			for(int c=0;c<gamingView.getC();c++){
				gamingView.getTabPlayerLabel()[l][c].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent evt) {
						putPionViewEvent(evt);
					}
				});	
			}
		}
		
		/*
		 * Launcher Listeners
		 * 
		 */
		gameLauncher.getQuitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quitGameEvent(evt);				
			}
		});
		
		gameLauncher.getPlayServerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientOrServer(true);
			}
		});
		
		gameLauncher.getPlayClientButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientOrServer(false);
			}
		});
		
	}
	
	/**
	 * M�thode ajoutant des listeners sur la grille de l'adversaire.
	 */
	private void addTabOpponentListener(){
		for(int l=0;l<gamingView.getL();l++){
			
			for(int c=0;c<gamingView.getC();c++){
				gamingView.getTabOpponentLabel()[l][c].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent evt) {
						myTarget =null;
						fireEvent(evt); // R�cupere la coordonn�e du tir effectu�
					
					}
				});	
			}
		}
	}
	
	
	/**
	 * M�thode permettant d'instance le socket server ou le socket client, en fonction du choix fait sur le launcher
	 *
	 * @param b : true pour le socket server et false pour le socket client
	 */
	private void clientOrServer(boolean b){	
		setServer(b);
		if(debug)System.out.println("debug isServer : "+b);
		if(getIpFromLauncher()){
			if(isServer){
				try {
					//Creation du serveur
					server = new Server();
					if(debug) System.out.println("Server active and client accepted");
					server.write(new String("Bienvenue sur le seveur"));				
				} catch (IOException e) {
					socketExceptionCatch(server);
				}
				
			} else {
				
				// Cr�ation du Client
				try {
					client = new Client(ipAdv,Integer.parseInt(gameLauncher.getNumPortServer().getText()));
					String welcomStr = client.read(String.class);
					if(debug) System.out.println("Connected to server !");
					if(debug) System.out.println(welcomStr);
				} catch (IOException | ClassNotFoundException e) {
					socketExceptionCatch(client);
				}
			}
			gameLauncher.dispose();
			gamingView.setVisible(true);
			JOptionPane.showMessageDialog(null, "Connexion �tablie !\nVous pouvez placer vos vaisseaux");
		}
		else JOptionPane.showMessageDialog(null, "Adresse Ip non valide");
	}
		
	/**
	 * Modifie la valeur logique "estServeur"
	 *
	 * @param isServer false : n'est pas serveur, true : est serveur
	 */
	private void setServer(boolean isServer){
		this.isServer = isServer;		
	}
	
	
	
	/**
	 * m�thode qui va r�cup�rer l'ip rentr�e par le client dans le launcher, et v�rifier si elle est valide
	 *
	 * @return true si l'ip est valide, false si elle ne l'est pas.
	 */
	private boolean getIpFromLauncher(){
		ipAdv = gameLauncher.getIpAdv().getText();	
		try {
			@SuppressWarnings("unused")
			InetAddress ip = InetAddress.getByName(ipAdv);
		} catch (UnknownHostException e) {
			return false;
		}
		return true;
	}
	

	/**
	 * M�thode appel�e lors d'un clic sur le panel de choix des bateaux
	 *
	 * @param evt1 le MouseEvent du panel de choix des bateaux
	 */
	private void selectCraftEvent(MouseEvent evt1){
		int c = ((MyJLabels)evt1.getSource()).getColumn();
		choice = c;
	}

	
	
	/**
	 * M�thode li�es au listener du bouton quitter de {@link PlayingView}
	 *
	 * @param e l'actionEvent
	 */
	private void quitGameEvent(ActionEvent e){
		gamingView.dispose();
		if(server != null && client != null){
			try {
				if(isServer)server.close();
				else client.close();
			} catch (IOException e1) {}
		}
		JOptionPane.showMessageDialog(null, "Merci d'avoir jou� � notre jeu !");
		System.exit(0);
	}
	
	
	
	/**
	 * M�thode li�e au bouton reset de {@link PlayingView} permettant de r�initialiser l'affichage de la grille du joueur.
	 * 
	 */
	private void resetSpaceships(){
		if(!gameReady){
			if(JOptionPane.showConfirmDialog(gamingView.getBackgroundLabel(), "Etes vous s�r de vouloir r�initialiser la position de tous les vaisseaux ?")==0){
				for(int c=0;c<gamingView.getC();c++){
					for(int l=0;l<gamingView.getL();l++){
						gamingView.getTabPlayerLabel()[l][c].setIcon(null);
					}
				}	
				resetPlacement();
				SpaceHunter.setNbInstance(0);
				SpaceCraft.setNbInstance(0);
				AdmiralSpaceCraft.setNbInstance(0);
				DeathStar.setNbInstance(0);
				spaceshipCounter = 0;
			}
		}
		else JOptionPane.showMessageDialog(null, "Ce n'est pas bien de vouloir retirer ses vaisseaux\nen cours de partie !");
	}
	
	
	
	/**
	 * M�thode appel�e lors de l'activation du bouton Pret de {@link PlayingView}, va informer l'adversaire que sa grille est pr�te
	 * et attendre que ce dernier soit pr�t �galement.
	 *
	 * @param e the e
	 */
	private void readyEvent(ActionEvent e){
		if(!gameReady){
			if(spaceshipCounter==6){
				gameReady = true;
				nbVieAdvers = 19;
				if(debug) System.out.println("nombre de vie total : "+nbVieTotal);
				addTabOpponentListener();
				JOptionPane.showMessageDialog(null, "�tat \"pr�t\" envoy� au serveur.. \n En attente de l'adversaire..");
				if(isServer){
					try {
						server.write(new String("Je suis pr�t !"));
						String str = server.read(String.class);
						if(debug) System.out.println(str);
						if(debug) System.out.println("Les pions sont plac�s, le jeu peut commencer...");
						JOptionPane.showMessageDialog(null, "A vous de jouer");
					} catch (Exception e1) {
						socketExceptionCatch(server);
					}				
				}else {
					try {
						client.write(new String("Je suis pr�t !"));
						String str = client.read(String.class);
						if(debug) System.out.println(str);
						if(debug) System.out.println("Les pions sont plac�s, le jeu peut commencer...");
						clientReception(); /* Vu que le serveur commence le premier � jouer, le client lance d�ja une lecture bloquante qui attend la coordonn�e du serveur */
					} catch (Exception e1) {
						socketExceptionCatch(client);
					}
				}
				
			}else JOptionPane.showMessageDialog(null, "Il vous reste "+(6-spaceshipCounter)+" vaisseaux � placer !");
		}
		else JOptionPane.showMessageDialog(null, "Vous �tes d�ja pr�t !");
		
	}
	
	
	
	/**
	 * M�thode li�e au case de la grille de l'adversaire sur {@link PlayingView}
	 * On y g�re la communication tour par tour entre le serveur et le client.
	 *
	 * @param evt the evt
	 */
	private void fireEvent(MouseEvent evt){
			
			int l = ((MyJLabels)evt.getSource()).getLine();
			int c = ((MyJLabels)evt.getSource()).getColumn();
			
			myTarget = new Coord(l,c);
			if(opponentArea.getCase(l, c).isTouch()) {
				JOptionPane.showMessageDialog(null, "Ce tir a d�j� �t� fait !");
				if(debug) System.out.println("Coordonn�e d�ja victime de violence");
			}
			else{ /* Implementation communication */
				opponentArea.getCase(l, c).setTouch(true);
				if(debug) System.out.println("Coordonn�e pas encore martiris�e");
				if(isServer){
					serverSend();
					serverReception();
				}
				else{
					clientSend();
					clientReception();
				}
			}

	}

	
	
	/**
	 * M�thode regroupant la s�quence de lecture/r�ponses par le client lorsque le serveur envoie une coordonn�e 
	 */
	private void clientReception(){
		try {
			opponentTarget = client.read(Coord.class);
			Pion touchPion = fireOnCase(opponentTarget.getX(),opponentTarget.getY()); // Sort le pion qui est touch� (peut-etre null)
			if(touchPion != null){ //  si un pion existe � cet endroit
				modifyImage(true, opponentTarget, true);
				client.write(true); // envoi que c'est touch�
				client.write(touchPion.getName()); // .. et le nom du pion qui est touch�
				client.write(touchPion.isDead());
				nbVieTotal=nbVieTotal-1; // retire 1 pt de vie total
			} else {
				modifyImage(true, opponentTarget, false); // indique dans la grille du joueur o� l'adversaire vient de tirer
				client.write(false);  // si pas de vaisseaux touch�
			}
			JOptionPane.showMessageDialog(null, "A vous de jouer !");
		} catch (ClassNotFoundException | IOException e) {
			socketExceptionCatch(client);
		}
		if(nbVieTotal<=0){
			JOptionPane.showMessageDialog(null, "D�sol�, mais vous avez perdu..");
			try {
				client.close();
			} catch (IOException e) {
				socketExceptionCatch(client);
			}
			gamingView.dispose();
		}
	}
	
	/**
	 * M�thode regroupant la s�quence de lecture/r�ponses par le serveur lorsque le client envoie une coordonn�e 
	 */
	private void serverReception(){
		try {
			opponentTarget = server.read(Coord.class);
			Pion touchPion = fireOnCase(opponentTarget.getX(),opponentTarget.getY()); // Sort le pion qui est touch� (peut-etre null)
			if(touchPion != null){ //  si un pion existe � cet endroit
				modifyImage(true, opponentTarget, true);
				server.write(true); // envoi que c'est touch�
				server.write(touchPion.getName()); // .. et le nom du pion qui est touch�
				server.write(touchPion.isDead());
				nbVieTotal=nbVieTotal-1; // retire 1 pt de vie total
			} else {
				modifyImage(true, opponentTarget, false); // indique dans la grille du joueur o� l'adversaire vient de tirer
				server.write(false);  // si pas de vaisseaux touch�
			}
			JOptionPane.showMessageDialog(null, "A vous de jouer !");
		} catch (ClassNotFoundException | IOException e) {
			socketExceptionCatch(server);
		}	
		if(nbVieTotal<=0){
			JOptionPane.showMessageDialog(null, "D�sol�, mais vous avez perdu..");
			try {
				server.close();
			} catch (IOException e) {
				socketExceptionCatch(server);
			}
			gamingView.dispose();
		}	
	}

	/**
	 * M�thode regroupant la s�quence client lorsqu'il envoie une coordonn�e de tir au serveur et attend les r�ponses
	 */
	private void clientSend(){
		try {
			client.write(myTarget);
			if(client.read(boolean.class)) { // Lit la r�ponse suite au tir
				modifyImage(false, myTarget, true);
				String touchName = client.read(String.class);
				if(client.read(boolean.class)){
					JOptionPane.showMessageDialog(null, "Bravo ! Vous avez touch� et d�truit : "+touchName);
				}
				else JOptionPane.showMessageDialog(null, "Touch� !!");
				nbVieAdvers=nbVieAdvers-1;
			} else {
				modifyImage(false, myTarget, false);
				JOptionPane.showMessageDialog(null, "Votre tir s'est perdu dans les profondeurs de l'espace...");
			}
		} catch (IOException | HeadlessException | ClassNotFoundException e) {
			socketExceptionCatch(client);
		}
		if(nbVieAdvers<=0){
			JOptionPane.showMessageDialog(null, "Bravo !\n Vous avez gagn� la partie");
			gamingView.dispose();
		}
	}
	
	/**
	 * M�thode regroupant la s�quence serveur lorsqu'il envoie une coordonn�e de tir au serveur et attend les r�ponses
	 */
	private void serverSend(){
		try {
			server.write(myTarget);
			if(server.read(boolean.class)) { // Lit la r�ponse suite au tir
				modifyImage(false, myTarget, true);
				String touchName = server.read(String.class);
				if(server.read(boolean.class)){
					JOptionPane.showMessageDialog(null, "Bravo ! Vous avez touch� et d�truit : "+touchName);
				}
				else JOptionPane.showMessageDialog(null, "Touch� !!");
				nbVieAdvers=nbVieAdvers-1;
			} else {
				modifyImage(false, myTarget, false);
				JOptionPane.showMessageDialog(null, "Votre tir s'est perdu dans les profondeurs de l'espace...");
			}
		} catch (IOException | HeadlessException | ClassNotFoundException e) {
			socketExceptionCatch(server);
		}
		if(nbVieAdvers<=0){
			JOptionPane.showMessageDialog(null, "Bravo !\n Vous avez gagn� la partie");
			gamingView.dispose();
		}
	}
	
 	/**
	  * M�thode li�e � l'event de placement des pion sur la grille du joueur
	  *
	  * @param evt the evt
	  */
	 private void putPionViewEvent(MouseEvent evt) {
		int l = ((MyJLabels)evt.getSource()).getLine();
		int c = ((MyJLabels)evt.getSource()).getColumn();
		switch(choice){
		case 0 :
			if(SpaceHunter.getNbInstance()==0){
				if(putSpaceHunter(l, c)==0){
					gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_1.png")));
					gamingView.getTabPlayerLabel()[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_2.png")));
					if(debug) System.out.println("hunt :"+hunt1.getCase(0));
					spaceshipCounter++;
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else if(SpaceHunter.getNbInstance() == 1){
				if(putSpaceHunter(l, c)==0){
					gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_1.png")));
					gamingView.getTabPlayerLabel()[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceHunter/SpaceHunter_1_2.png")));
					if(debug) System.out.println("hunt2 :"+hunt2.getCase(0));
					spaceshipCounter++;
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			break;
		case 1 : 
			if(SpaceCraft.getNbInstance()== 0){
				if(putSpaceCraft(l, c) == 0){
					gamingView.getTabPlayerLabel()[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_1.png")));
					gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_2.png")));
					gamingView.getTabPlayerLabel()[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_3.png")));
					if(debug) System.out.println("spcCraft "+spc1.getCase(0));
					spaceshipCounter++;
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else if(SpaceCraft.getNbInstance() == 1){
				if(putSpaceCraft(l, c) == 0){
					gamingView.getTabPlayerLabel()[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_1.png")));
					gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_2.png")));
					gamingView.getTabPlayerLabel()[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/SpaceCraft/SpaceCraft_1_3.png")));
					if(debug) System.out.println("spcCraft2 "+spc2.getCase(0));
					spaceshipCounter++;
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			
			break;
		case 2 :
			if(AdmiralSpaceCraft.getNbInstance() == 0){
				if(putAdmiralSpaceCraft(l, c) == 0){
					gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_1.png")));
					gamingView.getTabPlayerLabel()[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_2.png")));
					gamingView.getTabPlayerLabel()[l+2][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_3.png")));
					gamingView.getTabPlayerLabel()[l+3][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/admiralSpaceCraft/admiralSpaceCraft_1_4.png")));
					if(debug) System.out.println("adm = "+adm.getCase(0));
					spaceshipCounter++;
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			break;
		case 3 :
			if(DeathStar.getNbInstance() == 0){
				if( putDeathStar(l, c) == 0){
					gamingView.getTabPlayerLabel()[l][c+1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_1.png")));
					gamingView.getTabPlayerLabel()[l-1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_2.png")));
					gamingView.getTabPlayerLabel()[l][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_3.png")));
					gamingView.getTabPlayerLabel()[l+1][c].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_4.png")));
					gamingView.getTabPlayerLabel()[l][c-1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/spaceship/DeathStar/deathStar_1_5.png")));
					if(debug) System.out.println("star = "+star.getCase(0));
					spaceshipCounter++;
				}
				else JOptionPane.showMessageDialog(null, "Emplacement non valide");
			}
			else JOptionPane.showMessageDialog(null, "Nombre de vaisseau maximum atteind sur la grille");
			break;
		default : JOptionPane.showMessageDialog(null, "Choisissez un pion sous la grille.");
		}
	}
	
	/**
	 * Socket exception catch.
	 *
	 * @param servSock the serv sock
	 */
	private void socketExceptionCatch(Server servSock){
		if(debug) System.out.println("flow error on server socket");
		try {
			servSock.close();
		} catch (IOException e) {
			if(debug) System.out.println("error socket closing");
		}
		System.exit(-1);
	}
	
	/**
	 * Socket exception catch.
	 *
	 * @param clientSock the client sock
	 */
	private void socketExceptionCatch(Client clientSock){
		if(debug) System.out.println("flow error on client socket");
		try {
			clientSock.close();
		} catch (IOException e) {
			if(debug) System.out.println("error client socket closing");
		}
		System.exit(-1);
	}
	
}
