package server.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
    ArrayList<Socket> clients = new ArrayList<>();
    ServerSocket server;
    public Server(int port)
    {
        try
        {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void acceptClients()
    {
        for (Socket client : clients)
        {
            try
            {
                client = server.accept();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        Server s = new Server(1);
    }
}
