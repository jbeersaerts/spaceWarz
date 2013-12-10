package be.ephec.controler;

import java.io.IOException;
import java.net.ServerSocket;

public class MyServer {
	private static int numPort = 10340;
	private ServerSocket server;
	
	public MyServer() throws IOException {
		this.server = new ServerSocket(numPort);
		System.out.println("Serveur à l'écoute du port : "+numPort);
	}

	public static int getNumPort() {
		return numPort;
	}

	public ServerSocket getServer() {
		return server;
	}
	
	

}
