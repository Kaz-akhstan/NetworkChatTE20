package client.model;

import java.io.*;
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
        try {
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bw = new BufferedWriter(new PrintWriter(client.getOutputStream(), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message)
    {

    }

    @Override
    public void run()
    {
        String msg = null;
        while (true)
        {
            try {
                msg = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < clients.size(); i++) {
                clients.get(i).sendMessage(msg);
            }
        }
    }
}
