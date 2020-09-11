package JavaSocketTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static int port = 3000;
	
	public static void main (String[] args) {
		try {
			
			// https://docs.oracle.com/javase/7/docs/api/java/net/ServerSocket.html
			// A server socket waits for requests to come in over the network. 
			// It performs some operation based on that request, 
			// and then possibly returns a result to the requester.
			
			// We create an instance of a server socket object
			var serverSocket = new ServerSocket(port);
			
			// Opens a connection and listens for client request
			// and returns a socket instance
			var socket = serverSocket.accept();
			
			// https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
			// This abstract class is the superclass of all classes representing an input stream of bytes.
			var inputStream = socket.getInputStream();
			
			// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/DataInputStream.html
			// Data input stream lets an application read primitive Java data types from an underlying input stream in a machine-independent way. 
			// An application uses a data output stream to write data that can later be read by a data input stream.
			var dataInputSteam = new DataInputStream(inputStream);  
			
			// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/DataInputStream.html#readUTF()
			// Bytes for this operation are read from the contained input stream.
			// a Unicode string.
			var dataUnicodeString = dataInputSteam.readUTF();  
			
			// Cast unicode string to string
			var dataString = (String)dataUnicodeString;
			
			// Print data to console
			System.out.println("message= "+dataString);  
			
			// https://docs.oracle.com/javase/7/docs/api/java/net/ServerSocket.html#close()
			// Closes this socket. Any thread currently blocked in accept() will throw a SocketException.
			serverSocket.close();  

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
