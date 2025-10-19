import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234); // 1234 can be any port number
        System.out.println("Server is running and waiting for client...");

        Socket socket = serverSocket.accept(); // Wait for client connection
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Read from client
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Send to client (autoFlush = true)

        String clientMessage = in.readLine(); // Wait for client message
        System.out.println("Client says: " + clientMessage);

        out.println("Hello from server!"); // Reply to client

        socket.close();
        serverSocket.close();
    }
}
