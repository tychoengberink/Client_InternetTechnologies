package nl.MenTych.lvl1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    public static void main(String[] args) {
        //Setup the frame and the panel inside.
        JFrame frame = new JFrame("Controller window");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel namelabel = new JLabel("Username: ");
        JTextField usernameinput = new JTextField(10);
        JLabel label = new JLabel("Create a new client by clicking the button");
        JButton button = new JButton();
        button.setText("Create client");
        panel.add(namelabel);
        panel.add(usernameinput);
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = usernameinput.getText();

                if (!username.replace(" ", "_").matches("(\\w)\\w+")) {
                    //Username is not correct so try again also make text red.
                    usernameinput.setForeground(Color.red);
                } else {
                    //User name is correct. Create new thread and reset the input/panel.
                    usernameinput.setForeground(Color.black);
                    Thread client = new Thread(new Client("127.0.0.1", 1337, username));
                    client.start();
                    frame.revalidate();
                    usernameinput.setText("");
                }
            }
        });
    }
}