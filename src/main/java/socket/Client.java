package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final String LOCALHOST = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(LOCALHOST, Server.SERVER_PORT);
            InputStream from = socket.getInputStream();
            OutputStream to = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(from));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to));
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is your name?");
            String message = scanner.nextLine();
            writer.write(message);
            writer.newLine();
            writer.flush();
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Connection error");
        }
    }
}
