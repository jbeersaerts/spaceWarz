package be.ephec.controler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient extends Socket {
	ObjectOutputStream oos=null;
	ObjectInputStream ois=null;

	public MyClient(String ipAddress) throws UnknownHostException, IOException {
		super(ipAddress,10340);
		System.out.println("DEBUG creation socket faite");
		oos = new ObjectOutputStream(this.getOutputStream());	// Lui il l'aime bien.
		//ois = new ObjectInputStream(this.getInputStream());	// Lui non.. ???
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}
	

}
