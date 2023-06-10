/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cvmaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
//hello my name is hammad.

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
                     openMainPage();
                    dispose();
                    JOptionPane.showMessageDialog(SignUpPageGUI.this, "Sign up successful!");
                } else {
                    JOptionPane.showMessageDialog(SignUpPageGUI.this, "Username already exists! Please choose a different username.");
                }
            }
        });
    }
 private void openMainPage() {
        Mainpage mainPage = new Mainpage();
        mainPage.setVisible(true);
    }
}

class Mainpage extends JFrame {
    public Mainpage() {
        super("Main Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame to fullscreen
setVisible(true);

JPanel buttonPanel = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.insets = new Insets(10, 10, 10, 10);
getContentPane().setBackground(new Color(216, 191, 216));
// Create the labels with images
ImageIcon image1 = new ImageIcon("temp1.png");
ImageIcon image2 = new ImageIcon("temp2.png");
ImageIcon image3 = new ImageIcon("temp3.png");
ImageIcon image4 = new ImageIcon("temp4.png");
ImageIcon image5 = new ImageIcon("temp5.png");
ImageIcon image6 = new ImageIcon("temp6.png");

JLabel label1 = new JLabel(image1);
JLabel label2 = new JLabel(image2);
JLabel label3 = new JLabel(image3);
JLabel label4 = new JLabel(image4);
JLabel label5 = new JLabel(image5);
JLabel label6 = new JLabel(image6);

// Create the buttons for templates
JButton template1Button = new JButton("Template 1");
JButton template2Button = new JButton("Template 2");
JButton template3Button = new JButton("Template 3");
JButton template4Button = new JButton("Template 4");
JButton template5Button = new JButton("Template 5");
JButton template6Button = new JButton("Template 6");

Color buttonColor = new Color(0x4976EA);
Color textColor = Color.WHITE;

template1Button.setBackground(buttonColor);
template1Button.setForeground(textColor);

template2Button.setBackground(buttonColor);
template2Button.setForeground(textColor);

template3Button.setBackground(buttonColor);
template3Button.setForeground(textColor);

template4Button.setBackground(buttonColor);
template4Button.setForeground(textColor);

template5Button.setBackground(buttonColor);
template5Button.setForeground(textColor);

template6Button.setBackground(buttonColor);
template6Button.setForeground(textColor);


// Add action listeners to the buttons
template1Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Temp1 cvCreator = new Temp1();
                   cvCreator.createForm();
    }
});

template2Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Temp2 cvCreator = new Temp2();
                   cvCreator.createForm();
    }
});

template3Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       Temp3 cvCreator = new Temp3();
                   cvCreator.createForm();
    }
});

template4Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       Temp4 cvCreator = new Temp4();
                   cvCreator.createForm();
    }
});

template5Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Temp5 cvCreator = new Temp5();
                   cvCreator.createForm();
    }
});

template6Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Temp6 cvCreator = new Temp6();
                   cvCreator.createForm();
    }
});

// Set the preferred size for the labels
label1.setPreferredSize(new Dimension(360, 360));
label2.setPreferredSize(new Dimension(360, 360));
label3.setPreferredSize(new Dimension(360, 360));
label4.setPreferredSize(new Dimension(360, 360));
label5.setPreferredSize(new Dimension(360, 360));
label6.setPreferredSize(new Dimension(360, 360));

// Add the components to the panel
gbc.gridx = 0;
gbc.gridy = 0;
buttonPanel.add(label1, gbc);

gbc.gridx = 1;
buttonPanel.add(label2, gbc);

gbc.gridx = 2;
buttonPanel.add(label3, gbc);

gbc.gridx = 0;
gbc.gridy = 1;
buttonPanel.add(template1Button, gbc);

gbc.gridx = 1;
buttonPanel.add(template2Button, gbc);

gbc.gridx = 2;
buttonPanel.add(template3Button, gbc);

gbc.gridx = 0;
gbc.gridy = 2;
buttonPanel.add(label4, gbc);

gbc.gridx = 1;
buttonPanel.add(label5, gbc);

gbc.gridx = 2;
buttonPanel.add(label6, gbc);

gbc.gridx = 0;
gbc.gridy = 3;
buttonPanel.add(template4Button, gbc);

gbc.gridx = 1;
buttonPanel.add(template5Button, gbc);

gbc.gridx = 2;
buttonPanel.add(template6Button, gbc);

// Add the panel to the frame
add(buttonPanel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JLabel selectTemplateLabel = new JLabel("Select Template");
    selectTemplateLabel.setFont(new Font("Arial", Font.BOLD, 24));
    selectTemplateLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JPanel leftCornerPanel = new JPanel();
        leftCornerPanel.setBackground(new Color(216, 191, 216));
        JPanel rightCornerPanel = new JPanel();
        rightCornerPanel.setBackground(new Color(216, 191, 216));

        // Add the panels to the frame using BorderLayout
        add(leftCornerPanel, BorderLayout.WEST);
        add(rightCornerPanel, BorderLayout.EAST);
    add(selectTemplateLabel, BorderLayout.NORTH);
    add(buttonPanel, BorderLayout.CENTER);
    
    setVisible(true);
    setLocationRelativeTo(null);
        
    }
}

