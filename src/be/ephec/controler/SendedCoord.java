package be.ephec.controler;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SendedCoord implements Serializable {
	private static final long serialVersionUID = 1L; // ?? c'était dans l'exemple avec le livre :D
	private int x;
	private int y;
	
	public SendedCoord() {
		x = 0;
		y = 0;
	}
	public SendedCoord(int x,int y) {
		this.x = x;
		this.y = y;
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeInt(x);
		out.writeInt(y);
	}
	private void readObject(ObjectInputStream in) throws IOException {
		x = in.readInt();
		y = in.readInt();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return ("("+getX()+ ","+getY()+")");
	}
	

}
