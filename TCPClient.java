import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // For console input

        System.out.print("Enter server IP (e.g., 127.0.0.1): ");
        String serverIP = userInput.readLine();

        Socket socket = new Socket(serverIP, 1234); // Connect to server IP and port 1234
        System.out.println("Connected to server!");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Send to server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Receive from server

        out.println("Hello from client!"); // Send message to server

        String response = in.readLine(); // Wait for reply
        System.out.println("Server says: " + response);

        socket.close();
    }
}
