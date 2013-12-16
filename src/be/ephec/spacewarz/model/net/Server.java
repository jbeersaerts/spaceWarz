package be.ephec.spacewarz.model.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * La classe Server permet d'instancier un serveur ainsi qu'un socket pour la 
 * communication avec un client{@link Server}.
 * 
 * @author Olivier Vroman & Jonathan Beersaerts
 *
 */
public class Server {
	
	private ServerSocket serverSock;
	private Socket socketForAccept;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private int numPort = 2014;
	
	/**
	 * Le constructeur de la classe Server permet d'instancier un serveur ainsi que le socket n�cessaire
	 * pour la communication avec la classe client.
	 * 
	 * Le constructeur utilise le num�ro de port 2014, mais dans le cas o� il ne serait pas disponible, le num�ro de port
	 * est incr�ment� jusqu'� ce qu'il soit utilisable.
	 * 
	 * Le constructeur attend la connection du client sur son socket pour ensuite initialiser les flux d'entr�e et de sotie.
	 */
	public Server(){
		boolean connected = false;
		do{
			try {
				serverSock = new ServerSocket(numPort);
				System.out.println("Debug");
				JOptionPane.showMessageDialog(null, "Serveur � l'�coute sur le port "+numPort);
				socketForAccept = serverSock.accept();
				
				out = new ObjectOutputStream(socketForAccept.getOutputStream());
					out.flush();
				
				in = new ObjectInputStream(socketForAccept.getInputStream());
				
				connected = true;
			} catch (IOException e) {
				System.out.println(numPort+" occup�, essai d'un autre port");
				numPort++;
			}
		}while(!connected);
	}
	
	/**
	 * M�thode g�n�rique permettant l'�criture de tout type d'objet ou type primitif 
	 * sur le flux de sortie du socket serveur.
	 * 
	 * @param obj : l'objet ou type primitif qui sera �crit sur le flux de sortie
	 * 				En cas d'�criture d'objet, il est n�cessaire que la classe de l'objet
	 * 				impl�mente l'interface {@link Serializable} .
	 * @throws IOException : En cas d'erreur lors de l'�criture sur le flux de sortie du socket.
	 */
	public <E> void write(E obj) throws IOException{
		out.writeObject(obj);
		out.flush();
	}
	
	/**
	 * M�thode g�n�rique permettant la lecture de tout type d'objet ou type primitif 
	 * sur le flux d'entr�e du socket serveur.
	 * M�thode bloquante tant qu'il n'y a pas d'objets ou de types primitifs � lire sur le flux.
	 * 
	 * @param readClass : Indique la classe de l'objet ou le type primitif � lire sur le flux d'entr�e du socket.
	 * 					  Cette indication se pr�sente sous la forme type/Objet.class. Exemple : 
	 * 					  Server server = new Server();
	 * 					  String strRead = server.read(String.class);
	 * 					  int intRead = server.read(int.class);
	 * @return : Renvoi l'objet ou le type primitif lu sur le flux d'entr�e du socket. 
	 * 			 L'objet ou type primitif devant obligatoirement �tre du type sp�cifi� dans l'argument de la m�thode
	 * @throws ClassNotFoundException : Exception lanc�e si la classe sp�cifi�e en argument n'est pas trouv�e
	 * @throws IOException : En cas de mauvaise lecture
	 */
	@SuppressWarnings("unchecked")
	public <E> E read(Class<E> readClass) throws ClassNotFoundException, IOException{
		return (E)in.readObject();
	}

	/**
	 * M�thode de fermeture du socket serveur ainsi que des flux d'entr�e et de sortie.
	 * @throws IOException : En cas d'erreur lors de la fermeture du socket ou des flux In/Out.
	 */
	public void close() throws IOException{
		in.close();
		out.close();
		socketForAccept.close();
	}
	
}