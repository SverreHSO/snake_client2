package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by sverreostgaard on 02.12.15.
 * Class: creates the SignUp GUI.
 */
public class SignUp extends JPanel {

    // Declares variables used in the class
    private JLabel lblSignUp;
    private JLabel lblInsert;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblEmail;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldEmail;
    private JButton btnSignUp1;
    private JButton btnBack4;

    /**
     * Constructor: Creates the SignUp panel.
     */
    public SignUp() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setBounds(100, 100, 700, 400);
        setLayout(null);

        // Creates textfields, labels and buttons, assign them attributes and adds them to the panel.

        lblSignUp = new JLabel("Sign Up");
        lblSignUp.setForeground(Color.WHITE);
        lblSignUp.setFont(new Font("Verdana", Font.PLAIN, 25));
        lblSignUp.setBounds(180, 10, 150, 40);
        add(lblSignUp);

        lblInsert = new JLabel("Please Insert your personal information:");
        lblInsert.setForeground(Color.WHITE);
        lblInsert.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblInsert.setBounds(80, 60, 300, 20);
        add(lblInsert);

        lblFirstName = new JLabel("First Name:");
        lblFirstName.setForeground(Color.WHITE);
        lblFirstName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblFirstName.setBounds(50, 105, 90, 20);
        add(lblFirstName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setForeground(Color.WHITE);
        lblLastName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblLastName.setBounds(50, 145, 90, 20);
        add(lblLastName);

        lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblUsername.setBounds(50, 185, 90, 20);
        add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblPassword.setBounds(50, 225, 90, 20);
        add(lblPassword);

        lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblEmail.setBounds(50, 265, 90, 20);
        add(lblEmail);

        textFieldFirstName = new JTextField();
        textFieldFirstName.setToolTipText("Insert first name");
        textFieldFirstName.setFont(new Font("Verdana", Font.PLAIN, 13));
        textFieldFirstName.setBounds(160, 100, 140, 30);
        add(textFieldFirstName);
        textFieldFirstName.setColumns(10);

        textFieldLastName = new JTextField();
        textFieldLastName.setToolTipText("Insert last name");
        textFieldLastName.setBounds(160, 140, 140, 30);
        textFieldLastName.setColumns(10);
        add(textFieldLastName);

        textFieldUsername = new JTextField();
        textFieldUsername.setToolTipText("Insert username");
        textFieldUsername.setBounds(160, 180, 140, 30);
        textFieldUsername.setColumns(10);
        add(textFieldUsername);

        textFieldPassword = new JTextField();
        textFieldPassword.setToolTipText("Insert new password");
        textFieldPassword.setBounds(160, 220, 140, 30);
        textFieldPassword.setColumns(10);
        add(textFieldPassword);

        textFieldEmail = new JTextField();
        textFieldEmail.setToolTipText("Insert Email");
        textFieldEmail.setBounds(160, 260, 140, 30);
        add(textFieldEmail);

        /**
         * Creates btnSignUp1 and defines the ActionCommand for it (Sign Up1).
         */
        btnSignUp1 = new JButton("Sign Up");
        btnSignUp1.setBounds(170, 300, 117, 29);
        btnSignUp1.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnSignUp1.setActionCommand("Sign Up1");
        add(btnSignUp1);

        /**
         * Creates btnBack4 and defines the ActionCommand for it (Back4).
         */
        btnBack4 = new JButton("Back");
        btnBack4.setBounds(40, 300, 117, 29);
        btnBack4.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnBack4.setActionCommand("Back4");
        add(btnBack4);

    }

    /**
     * Method: sets the text in all JTextFileds in the panel to blank/nothing. ie. clearing the text.
     */
    public void ClearText()
    {
        textFieldFirstName.setText("");
        textFieldLastName.setText("");
        textFieldUsername.setText("");
        textFieldPassword.setText("");
        textFieldEmail.setText("");
    }

    /**
     * Method: converts textFieldFirstName into a String and gets first name
     */
    public String getTextFieldFirstName() {
        return textFieldFirstName.getText();
    }

    /**
     * Method: converts textFieldLastName into a String and gets last name
     */
    public String getTextFieldLastName() {
        return textFieldLastName.getText();
    }

    /**
     * Method: converts textFieldUsername into a String and gets username
     */
    public String getTextFieldUsername() {
        return textFieldUsername.getText();
    }

    /**
     * Method: converts textFieldPassword into a String and gets password
     */
    public String getTextFieldPassword() {
        return textFieldPassword.getText();
    }

    /**
     * Method: converts textFieldEmail into a String and gets email
     */
    public String getTextFieldEmail() {
        return textFieldEmail.getText();
    }

    /**
     * Method: Adds ActionListeners to btnSignUp1 and btnBack4.
     * The parameter a is an object of ActionListener.
     */
    public void SignUpAL(ActionListener s) {
        btnSignUp1.addActionListener(s);
        btnBack4.addActionListener(s);
    }

}