package client;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Chat {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("10.80.47.37"/*"192.168.1.15"*/, 5);
            Client c = new Client(s, JOptionPane.showInputDialog(null, "Enter Username"));
            ClientView v = new ClientView();
            Controller controller = new Controller(c, v);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
