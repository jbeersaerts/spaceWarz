package be.ephec.controler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketCoteServeur {
	private Socket s;
	private ObjectOutputStream oos=null;
	private ObjectInputStream ois= null;
	
	public SocketCoteServeur(Socket s) throws ClassNotFoundException {

		//try{
			this.s = s;
			//oos = new ObjectOutputStream(s.getOutputStream());    // Il n'aime pas ni oos, ni ois... ???
			//ois = new ObjectInputStream(s.getInputStream());
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
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
