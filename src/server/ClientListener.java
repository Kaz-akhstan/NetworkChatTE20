package server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientListener implements Runnable {
    public static ArrayList<ClientListener> clients = new ArrayList<>();
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private String username;

    public ClientListener(Socket socket)
    {
        this.socket = socket;
        try {
            this.pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = br.readLine();
            clients.add(this);
            sendMessage("New Connection");
        } catch (IOException e) {
            e.printStackTrace();
            closeConnection(br, pw, socket);
        }
    }

    private void closeConnection(BufferedReader br, PrintWriter pw, Socket socket) {
        clients.remove(this);
        sendMessage("Client has disconnected");
        try {
            br.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        for (ClientListener client : clients) {
            try {
                if (!client.username.equals(username)) {
                    client.pw.println(message + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
                closeConnection(br, pw, socket);
            }
        }
    }

    @Override
    public void run() {
        String msg;
        while (socket.isConnected())
        {
            try {
                msg = br.readLine();
                sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
