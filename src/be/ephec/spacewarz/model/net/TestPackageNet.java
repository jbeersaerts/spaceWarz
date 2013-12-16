package be.ephec.spacewarz.model.net;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Serializable;

import org.junit.Test;

import be.ephec.spacewarz.model.area.Case;
import be.ephec.spacewarz.model.area.Coord;


/**
 * La classe TestPackageNet regroupe un ensemble de test JUnit testant les classes du package be.ephec.spacewarz.model.net. 
 * 
 */
public class TestPackageNet {

	/**
	 * testReadyTransfert permet de tester la connexion et l'envoi de l'information ready entre client et serveur .
	 */
	@Test
	public void testReadyTransfert() {
		
		new Runnable() {public void run() {
			Server server = new Server();
			try {
				server.write(new String("Server is ready"));
				assertEquals("Client is ready", (server.read(String.class)));
				server.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}};
		
		new Runnable(){public void run(){
			try {
				Client client = new Client("localhost",2014);
				client.write(new String("Client is ready"));
				assertEquals("Server is ready", (client.read(String.class)));
				client.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}};
	}
	
	/**
	 * testSendCoord teste le bon envoi de Coordonnée du serveur vers le client
	 */
	@Test
	public void testSendCoord(){
		new Runnable() {public void run() {
			Server server = new Server();
			Coord sendCoord = new Coord(5,9);
			try {
				server.write(sendCoord);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}};
		
		new Runnable(){public void run(){
			try {
				Coord readCoord = new Coord(5,9);
				Client client = new Client("localhost",2014);
				assertEquals(readCoord.toString(),client.read(Coord.class).toString());
				client.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}};
	}
	
	
	/**
	 * Test vérifiant si la méthode write renvoie bien une exeption si l'objet n'implémente pas {@link Serializable}
	 */
	@Test
	public void testExeption(){
		new Runnable() {public void run() {
			Server server = new Server();
			Case caseTest = new Case(1,2);
			try {
				server.write(caseTest); // Case n'implémente pas sérializable donc une expection devrait être lancée
				fail("exception non lancée...");
			} catch (IOException e) {
			}
			
		}};
		
		new Runnable(){public void run(){
			try {
				Client client = new Client("localhost",2014);
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}};
	}
}
