package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created by sverreostgaard on 27.11.15.
 * Class: creates the LogIn GUI.
 */
public class LogIn extends JPanel {

    // Declares variables used in the class
    private JLabel lblLogIn;
    private JLabel lblUsername;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel lblPassword;
    private JButton btnLogIn;
    private JButton btnSignUp;

    /**
     * Constructor: Creates the LogIn panel.
     */
    public LogIn() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setBounds(100, 100, 700, 400);
        setLayout(null);

        // Creates textfield, passwordfield, labels and buttons, assign them attributes and adds them to the panel.

        lblLogIn = new JLabel("Snake Log In");
        lblLogIn.setForeground(Color.WHITE);
        lblLogIn.setFont(new Font("Verdana", Font.BOLD, 35));
        lblLogIn.setBounds(200, 100, 300, 50);
        add(lblLogIn);

        lblUsername = new JLabel("Username");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Verdana", Font.BOLD, 15));
        lblUsername.setBounds(255, 182, 90, 20);
        add(lblUsername);


        textField = new JTextField();
        textField.setToolTipText("Insert username");
        textField.setFont(new Font("Verdana", Font.PLAIN, 13));
        textField.setBounds(255, 210, 140, 30);
        textField.setColumns(10);
        add(textField);

        lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Verdana", Font.BOLD, 15));
        lblPassword.setBounds(255, 252, 90, 20);
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("Insert password");
        passwordField.setBounds(255, 280, 140, 30);
        passwordField.setColumns(10);
        add(passwordField);

        /**
         * Creates btnLogIn and defines the ActionCommand for it (Log In).
         */
        btnLogIn = new JButton("Log in");
        btnLogIn.setBounds(265, 320, 117, 29);
        btnLogIn.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnLogIn.setActionCommand("Log In");
        add(btnLogIn);

        /**
         * Creates btnSignUp and defines the ActionCommand for it (Sign Up).
         */
        btnSignUp = new JButton("Sign up");
        btnSignUp.setBounds(265, 400, 117, 29);
        btnSignUp.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnSignUp.setActionCommand("Sign Up");
        add(btnSignUp);

    }


    /**
     * Method: Sets the text in textField and passwordField to blank/nothing. ie. clearing the text.
     */
    public void ClearText() {
        textField.setText("");
        passwordField.setText("");
    }

    /**
     * Method: Converts textField into string and gets the username.
     */
    public String getUserName() {
        return textField.getText();
    }

    /**
     * Method: Converting passwordField from a char array to a String and gets password.
     */
    public String getPassword() {
        String strPassword = new String(passwordField.getPassword());
        return strPassword;
    }

    /**
     * Method: Adds ActionListeners to btnLogIn and btnSignUp.
     * The parameter s is an object of ActionListener.
     */
    public void LogInAL(ActionListener s) {
        btnLogIn.addActionListener(s);
        btnSignUp.addActionListener(s);
    }

}
