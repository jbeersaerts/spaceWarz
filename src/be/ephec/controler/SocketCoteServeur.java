package be.ephec.controler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketCoteServeur {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket s;
	private int num;
	private SendedCoord c = new SendedCoord(4, 7);
	private String receivedResponse;
	
	public SocketCoteServeur(Socket s, int num) throws ClassNotFoundException {
		this.s = s;
		this.num = num;
		try{
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			oos.writeObject(c);
			System.out.println("J'écris la coordonnée "+c+" sur le socket.");
			
			receivedResponse = (String)ois.readObject();
			System.out.println("Le client m'a répondu : "+receivedResponse);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ObjectOutputStream getOos(){
		return oos;
	}
}
