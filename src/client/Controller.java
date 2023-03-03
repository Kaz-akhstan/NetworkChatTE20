package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Client client;
    private ClientView view;
    public Controller(Client client, ClientView view)
    {
        this.client = client;
        this.view = view;

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setContentPane(view.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        view.addSendListener(new sendListener());
    }

    private class sendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setTextArea1("Meddelande");
        }
    }
}
