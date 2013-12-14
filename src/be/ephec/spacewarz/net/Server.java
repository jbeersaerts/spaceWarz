package be.ephec.spacewarz.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	
	private ServerSocket serverSock;
	private Socket socketForAccept;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private int numPort = 2014;
	
	public Server(){
		boolean connected = false;
		do{
			try {
				serverSock = new ServerSocket(numPort);
				System.out.println("Debug");
				JOptionPane.showMessageDialog(null, "Serveur à l'écoute sur le port "+numPort);
				socketForAccept = serverSock.accept();
				
				out = new ObjectOutputStream(socketForAccept.getOutputStream());
					out.flush();
				
				in = new ObjectInputStream(socketForAccept.getInputStream());
				
				connected = true;
			} catch (IOException e) {
				System.out.println(numPort+" occupé, essai d'un autre port");
				numPort++;
			}
		}while(!connected);
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