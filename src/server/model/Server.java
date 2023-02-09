package server.model;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public Server(int port)
    {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptClients()
    {

    }

    public static void main(String[] args) {

    }
}
