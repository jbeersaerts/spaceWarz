package be.ephec.spacewarz.model.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * La classe Client permet d'instancier un socket client auprès d'un serveur
 * en fonction de l'adresse ip et le numéro de port necessaire à la connexion au serveur.
 * Elle est composée du dit socket et d'attributs de lecture/écriture
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
	 * de lecture et d'écriture sur le socket.
	 * 
	 * @param adr : IP du serveur auquel le socket va se connecter.
	 * @param port : Port sur lequel le serveur est à l'écoute.
	 * @throws UnknownHostException : Au cas où la connection au socket échoue.
	 * @throws IOException : En cas d'argument non valide.
	 */
	public Client(String adr, int port) throws UnknownHostException, IOException{
		soc = new Socket(adr, port);
		in = new ObjectInputStream(soc.getInputStream());
		out = new ObjectOutputStream(soc.getOutputStream());
			out.flush();
	}
	
	/**
	 * Méthode générique permettant l'écriture de tout type d'objet ou type primitif 
	 * sur le flux de sortie du socket.
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
	 * sur le flux d'entrée du socket.
	 * Méthode bloquante tant qu'il n'y a pas d'objets ou de types primitifs à lire sur le flux.
	 * 
	 * @param readClass : Indique la classe de l'objet ou le type primitif à lire sur le flux d'entrée du socket.
	 * 					  Cette indication se présente sous la forme type/Objet.class.<br/>Exemple : 
	 * 					  <pre>
	 * 					  <code>
	 * 			Client client = new Client(adr,port);
	 * 			String strRead = client.read(String.class);
	 * 			int intRead = client.read(int.class);</code>
	 *          </pre>
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
	 * Méthode de fermeture du socket ainsi que des flux d'entrée et de sortie.
	 * @throws IOException : En cas d'erreur lors de la fermeture du socket ou des flux In/Out.
	 */
	public void close() throws IOException{
		in.close();
		out.close();
		soc.close();
	}
	
}
