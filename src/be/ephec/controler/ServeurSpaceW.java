package be.ephec.controler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurSpaceW extends ServerSocket implements Runnable {
	ArrayList<SocketCoteServeur> listeClients = new ArrayList<SocketCoteServeur>();
	private static int nbClients = 0;
	private static int numPort = 2013;
	
	public ServeurSpaceW(int arg0) throws IOException {
		super(arg0);
		Thread t = new Thread(this);
		t.start(); // execute run() dans un process en parallele
		try{
			Thread.sleep(100);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		do{
			try{
				ServeurSpaceW sSW = new ServeurSpaceW(ServeurSpaceW.numPort);
				System.out.println("Le serveur écoute sur le port : "+numPort);
				break;
			} catch (IOException e) {
				numPort++;
				e.printStackTrace();
			}
		}while(true);
	}

	
	@Override
	public void run() {
		Socket s = null;
		do{
			try{
				s = this.accept();
				nbClients++;
				System.out.println("Nouveau client détecté.\n Nombre de clients : "+nbClients);
				try {
					listeClients.add(new SocketCoteServeur(s, nbClients));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(SocketCoteServeur cl : listeClients) {
					cl.getOos().writeObject("Bienvenue sur le serveur, client n°"+nbClients);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (s.isConnected());
	}
}
