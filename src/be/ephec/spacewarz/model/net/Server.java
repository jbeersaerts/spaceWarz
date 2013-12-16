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
	 * Le constructeur de la classe Server permet d'instancier un serveur ainsi que le socket nécessaire
	 * pour la communication avec la classe client.
	 * 
	 * Le constructeur utilise le numéro de port 2014, mais dans le cas où il ne serait pas disponible, le numéro de port
	 * est incrémenté jusqu'à ce qu'il soit utilisable.
	 * 
	 * Le constructeur attend la connection du client sur son socket pour ensuite initialiser les flux d'entrée et de sotie.
	 */
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
	
	/**
	 * Méthode générique permettant l'écriture de tout type d'objet ou type primitif 
	 * sur le flux de sortie du socket serveur.
	 * 
	 * @param obj : l'objet ou type primitif qui sera écrit sur le flux de sortie
	 * 				En cas d'écriture d'objet, il est nécessaire que la classe de l'objet
	 * 				implémente l'interface {@link Serializable} .
	 * @throws IOException : En cas d'erreur lors de l'écriture sur le flux de sortie du socket.
	 */
	public <E> void write(E obj) throws IOException{
		out.writeObject(obj);
		out.flush();
	}
	
	/**
	 * Méthode générique permettant la lecture de tout type d'objet ou type primitif 
	 * sur le flux d'entrée du socket serveur.
	 * Méthode bloquante tant qu'il n'y a pas d'objets ou de types primitifs à lire sur le flux.
	 * 
	 * @param readClass : Indique la classe de l'objet ou le type primitif à lire sur le flux d'entrée du socket.
	 * 					  Cette indication se présente sous la forme type/Objet.class. Exemple : 
	 * 					  Server server = new Server();
	 * 					  String strRead = server.read(String.class);
	 * 					  int intRead = server.read(int.class);
	 * @return : Renvoi l'objet ou le type primitif lu sur le flux d'entrée du socket. 
	 * 			 L'objet ou type primitif devant obligatoirement être du type spécifié dans l'argument de la méthode
	 * @throws ClassNotFoundException : Exception lancée si la classe spécifiée en argument n'est pas trouvée
	 * @throws IOException : En cas de mauvaise lecture
	 */
	@SuppressWarnings("unchecked")
	public <E> E read(Class<E> readClass) throws ClassNotFoundException, IOException{
		return (E)in.readObject();
	}

	/**
	 * Méthode de fermeture du socket serveur ainsi que des flux d'entrée et de sortie.
	 * @throws IOException : En cas d'erreur lors de la fermeture du socket ou des flux In/Out.
	 */
	public void close() throws IOException{
		in.close();
		out.close();
		socketForAccept.close();
	}
	
}