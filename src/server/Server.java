package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    ServerSocket server;
    ArrayList<Socket>clientList = new ArrayList<>();

    public Server(int port)
    {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void acceptClients()
    {
        while(true)
        {
            Socket client = null;
            try {
                client = server.accept();
                clientList.add(client);

                ClientListener cl = new ClientListener(client);
                Thread thread = new Thread(cl);
                thread.start();
                System.out.println("Client connected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server s = new Server(5);
        s.acceptClients();
    }
}