package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton login, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);

        // Heading
        JLabel heading = new JLabel("Simple Mines");
        heading.setBounds(800, 60, 300, 45);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        // Username label
        JLabel name = new JLabel("Enter username");
        name.setBounds(830, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        // Text field for name
        tfname = new JTextField();
        tfname.setBounds(735, 180, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(tfname);

        // Login button
        login = new JButton("Login");
        login.setBounds(735, 230, 120, 25);
        login.setBackground(new Color(30, 114, 254));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Back button
        back = new JButton("Back");
        back.setBounds(915, 230, 120, 25);
        back.setBackground(new Color(30, 114, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Window settings
        setSize(1200, 500);
        setLocation(200, 200);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String name = tfname.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                setVisible(false);
                new Quiz(name); // Start quiz with username
            }

        } else if (ae.getSource() == back) {
            setVisible(false); // Close window
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
