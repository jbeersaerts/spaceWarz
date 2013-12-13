package be.ephec.spacewarz.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket soc;
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public Client(String adr, int port) throws UnknownHostException, IOException{
		soc = new Socket(adr, port);
		in = new ObjectInputStream(soc.getInputStream());
		out = new ObjectOutputStream(soc.getOutputStream());
			out.flush();
	}
	
	public <E> void write(E obj) throws IOException{
		out.writeObject(obj);
			out.flush();
	}
	
	@SuppressWarnings("unchecked")
	public <E> E read(Class<E> readClass) throws ClassNotFoundException, IOException{
		return (E)in.readObject();
	}

	public void close() throws IOException{
		in.close();
		out.close();
		soc.close();
	}
	
}
