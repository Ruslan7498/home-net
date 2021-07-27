package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 5555;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket clientSocket = serverSocket.accept(); //ждем подключения
            InputStream from = clientSocket.getInputStream();
            OutputStream to = clientSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(from));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(to), true);
            String message = reader.readLine();
            System.out.println("New connection accepted");
            writer.println(String.format("Hi %s, your port is %d", message, clientSocket.getPort()));
        } catch (IOException e) {
            System.out.println("Connection error");
        }
    }
}
