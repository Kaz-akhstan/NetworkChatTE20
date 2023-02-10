package client.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
    public static final String ANSI_RED = "\u001B[31m";

    Socket socket;
    PrintWriter out;
    BufferedReader in;

    public Client(String ip, int port)
    {
        try
        {
            socket = new Socket(ip, port);
            System.out.println("Connection ready.");
        }
        catch (IOException e)
        {
            System.out.println(ANSI_RED + "Failed to connect to server.");
            e.printStackTrace();
        }
    }

    private void getStreams()
    {

    }

    public static void main(String[] args) {
        Client c = new Client("10.80.47.37", 1);
    }
}
