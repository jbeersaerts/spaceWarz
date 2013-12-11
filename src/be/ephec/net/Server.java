package be.ephec.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSock;
	private Socket socketForAccept;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public Server(int port) throws IOException{
		serverSock = new ServerSocket(port);
		System.out.println("Debug");
		socketForAccept = serverSock.accept();
		
		out = new ObjectOutputStream(socketForAccept.getOutputStream());
			out.flush();
		
		in = new ObjectInputStream(socketForAccept.getInputStream());
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
		socketForAccept.close();
	}
	
}