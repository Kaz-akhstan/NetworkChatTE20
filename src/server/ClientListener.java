package server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientListener implements Runnable {
    public static ArrayList < ClientListener > clients = new ArrayList < > ();
    Socket client;

    BufferedReader br;
    BufferedWriter bw;

    String username;

    public ClientListener(Socket client) {
        this.client = client;
        try {
            clients.add(this);
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bw = new BufferedWriter(new PrintWriter(client.getOutputStream(), true));
            this.username = br.readLine();
            sendMessage(username + " has connected");
        } catch (IOException e) {
            terminateListener(client, bw, br);
            e.printStackTrace();
        }
    }

    void disconnectClient() {
        clients.remove(this);
        sendMessage(username + " has disconnected");
    }

    void terminateListener(Socket client, BufferedWriter bw, BufferedReader br) {
        disconnectClient();
        try {
            bw.close();
            br.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        for (int i = 0; i < clients.size(); i++) {
            try {
                if (!clients.get(i).username.equals(username)) {
                    clients.get(i).bw.write(message);
                    clients.get(i).bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                terminateListener(client, bw, br);
            }
        }
    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = br.readLine();
                sendMessage(msg);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}