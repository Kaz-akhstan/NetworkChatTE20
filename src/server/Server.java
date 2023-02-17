package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    ServerSocket server;
    public Server(ServerSocket server)
    {
        this.server = server;
    }

    public void acceptClients()
    {
        try {
            while(!server.isClosed())
            {
                Socket client = server.accept();
                System.out.println("Client has connected");
                ClientListener clientListener = new ClientListener(client);
                Thread thread = new Thread(clientListener);
                thread.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void stopServer()
    {
        try
        {
            server.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Server s = new Server(new ServerSocket(1));
            s.acceptClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}