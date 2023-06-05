/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cvmaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public gui() {
        super("Login Page");

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        JLabel signUpLabel = new JLabel("Not registered yet?");
        JButton signUpButton = new JButton("Sign up");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel(new GridLayout(4, 1));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);

        JPanel signUpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signUpPanel.add(signUpLabel);
        signUpPanel.add(signUpButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(signUpPanel, BorderLayout.NORTH);

        container.add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform login logic
                dbconnection b = new dbconnection();
                boolean loginSuccess = b.login(username, password);
                if (loginSuccess) {
                    openMainPage();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(gui.this, "Invalid username or password!");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSignUpPage();
            }
        });
    }

    private void openSignUpPage() {
        SignUpPageGUI signUpPage = new SignUpPageGUI();
        signUpPage.setVisible(true);
        dispose();
    }

    private void openMainPage() {
        Mainpage mainPage = new Mainpage();
        mainPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new gui();
            }
        });
    }
}

class SignUpPageGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public SignUpPageGUI() {
        super("Sign Up Page");

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        JButton signUpButton = new JButton("Sign Up");

        JPanel loginPanel = new JPanel(new GridLayout(4, 1));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        JPanel signUpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signUpPanel.add(signUpButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(signUpPanel, BorderLayout.SOUTH);

        Container container = getContentPane();
        container.add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform sign-up logic
                dbconnection b = new dbconnection();
                boolean signUpSuccess = b.Signuppage(username, password);
                if (signUpSuccess) {
                    JOptionPane.showMessageDialog(SignUpPageGUI.this, "Sign up successful!");
                } else {
                    JOptionPane.showMessageDialog(SignUpPageGUI.this, "Username already exists! Please choose a different username.");
                }
            }
        });
    }
}

class Mainpage extends JFrame {
    public Mainpage() {
        super("Main Page");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

