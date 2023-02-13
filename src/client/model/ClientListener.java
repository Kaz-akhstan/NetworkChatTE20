package client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientListener implements Runnable
{
    public static ArrayList<ClientListener> clients = new ArrayList<>();
    Socket client;

    BufferedReader br;
    BufferedWriter bw;

    String username;

    public ClientListener(Socket client)
    {
        this.client = client;
    }

    @Override
    public void run()
    {

    }
}
