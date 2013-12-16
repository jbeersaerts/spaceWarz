package be.ephec.spacewarz.model.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * La classe Client permet d'instancier un socket client aupr�s d'un serveur
 * en fonction de l'adresse ip et le num�ro de port necessaire � la connexion au serveur.
 * Elle est compos�e du dit socket et d'attributs de lecture/�criture
 * ( ObjectOutput/InputStream ).
 * 
 * 
 * 
 * @author Olivier Vroman & Jonathan Beersaerts
 *
 */

public class Client {
	
	private Socket soc;
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	/**
	 * Le constructeur de la classe Client permet d'instancier un socket qui va ensuite
	 * se connecter au serveur choisi, ainsi qu'instancier les ObjectOutput/InputStream
	 * de lecture et d'�criture sur le socket.
	 * 
	 * @param adr : IP du serveur auquel le socket va se connecter.
	 * @param port : Port sur lequel le serveur est � l'�coute.
	 * @throws UnknownHostException : Au cas o� la connection au socket �choue.
	 * @throws IOException : En cas d'argument non valide.
	 */
	public Client(String adr, int port) throws UnknownHostException, IOException{
		soc = new Socket(adr, port);
		in = new ObjectInputStream(soc.getInputStream());
		out = new ObjectOutputStream(soc.getOutputStream());
			out.flush();
	}
	
	/**
	 * M�thode g�n�rique permettant l'�criture de tout type d'objet ou type primitif 
	 * sur le flux de sortie du socket.
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
	 * sur le flux d'entr�e du socket.
	 * M�thode bloquante tant qu'il n'y a pas d'objets ou de types primitifs � lire sur le flux.
	 * 
	 * @param readClass : Indique la classe de l'objet ou le type primitif � lire sur le flux d'entr�e du socket.
	 * 					  Cette indication se pr�sente sous la forme type/Objet.class.<br/>Exemple : 
	 * 					  <pre>
	 * 					  <code>
	 * 			Client client = new Client(adr,port);
	 * 			String strRead = client.read(String.class);
	 * 			int intRead = client.read(int.class);</code>
	 *          </pre>
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
	 * M�thode de fermeture du socket ainsi que des flux d'entr�e et de sortie.
	 * @throws IOException : En cas d'erreur lors de la fermeture du socket ou des flux In/Out.
	 */
	public void close() throws IOException{
		in.close();
		out.close();
		soc.close();
	}
	
}
