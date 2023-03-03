package client;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ClientView {
    private JButton button1;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(String textArea1) {
        this.textArea1.append(textArea1 + "\n");
    }

    private JTextField textField1;
    private JTextArea textArea1;
    private JPanel panel;
    private JTextPane textPane1;

    public JPanel getPanel() {
        return panel;
    }

    public void addSendListener(ActionListener actionListener)
    {
        button1.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setContentPane(new ClientView().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
