package be.ephec.controler;

import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketSpaceW extends Socket implements Runnable{
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private SendedCoord coord;
	private String response ="Dans l'eau !";
	
	public SocketSpaceW() throws UnknownHostException, IOException {
		super("127.0.0.1", 2013);
		ois = new ObjectInputStream(this.getInputStream());
		oos = new ObjectOutputStream(this.getOutputStream());
		try {
			coord = (SendedCoord)ois.readObject();
			//System.out.println("J'ai lu "+num+" sur le socket venant du serveur");
			System.out.println("J'ai reçu cette coordonnée : "+coord);
			oos.writeObject(response);
			System.out.println("J'ai répondu : "+response);
			
			Thread t = new Thread(this);
			t.start();
			Thread.sleep(100);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println("Ceci est la console du client n°"+num);
	}

	public static void main(String[] args) {
		try {
			SocketSpaceW s = new SocketSpaceW();
		} catch (UnknownHostException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		do {
			try {
				System.out.println(ois.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				try {
					this.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}while(this.isConnected());
	}
}
