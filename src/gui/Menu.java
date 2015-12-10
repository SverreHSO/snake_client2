package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created by sverreostgaard on 27.11.15.
 * Class: creates the Menu GUI.
 */
public class Menu extends JPanel {

    // Declares variables used in the class
    private JLabel lblMenu;
    private JButton btnJoinGame;
    private JButton btnCreateGame;
    private JButton btnDeleteGame;
    private JButton btnHighScore;

    private JButton btnLogOut;

    private JLabel lblUserName;
    private JLabel lblUserId;

    /**
     * Constructor: Creates the Menu panel.
     */
    public Menu() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setBounds(100, 100, 668, 395);
        setLayout(null);

        // creates label and buttons, assign them attributes and adds them to the panel.

        lblMenu = new JLabel("Menu");
        lblMenu.setForeground(Color.WHITE);
        lblMenu.setFont(new Font("Verdana", Font.BOLD, 35));
        lblMenu.setBounds(270, 70, 120, 50);
        add(lblMenu);

        /**
         * Creates all the buttons on the Menu panel and defines a specific action command to each.
         */
        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setFont(new Font("Verdana", Font.BOLD, 20));
        btnJoinGame.setForeground(Color.BLACK);
        btnJoinGame.setBounds(0, 170, 162, 150);
        btnJoinGame.setActionCommand("Join Game");
        add(btnJoinGame);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setFont(new Font("Verdana", Font.BOLD, 20));
        btnCreateGame.setBounds(162, 170, 162, 150);
        btnCreateGame.setActionCommand("Create Game");
        add(btnCreateGame);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setFont(new Font("Verdana", Font.BOLD, 20));
        btnDeleteGame.setBounds(324, 170, 162, 150);
        btnDeleteGame.setActionCommand("Delete Game");
        add(btnDeleteGame);

        btnHighScore = new JButton("High Score");
        btnHighScore.setFont(new Font("Verdana", Font.BOLD, 20));
        btnHighScore.setBounds(486, 170, 162, 150);
        btnHighScore.setActionCommand("High Score");
        add(btnHighScore);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnLogOut.setBounds(265, 350, 120, 50);
        btnLogOut.setActionCommand("Log Out");
        add(btnLogOut);

    }


    /**
     * Method: creates labels and sets the text to username an userId, and will show on the Menu panel when logged in.
     * The parameter, username and userId is the user info for the current user (the user that has logged in).
     */
    public void Information(String username, int userId)
    {
        lblUserName = new JLabel();
        lblUserName.setText("You ar logged in as: " + username);
        lblUserName.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblUserName.setBounds(5, 1, 200, 20);
        add(lblUserName);

        lblUserId = new JLabel();
        lblUserId.setText("Your user ID: " + userId);
        lblUserId.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblUserId.setBounds(5, 20, 100, 20);
        add(lblUserId);

    }

    /**
     * Method: sets the text in lblUsername and lblUserId to blank/nothing. ie. clearing the text.
     */
    public void ClearInfo()
    {
        lblUserName.setText("");
        lblUserId.setText("");
    }

    /**
     * Adds ActionListeners to each of the buttons.
     * The parameter a is an object of ActionListener.
     */
    public void MenuAL(ActionListener a)
    {
        btnJoinGame.addActionListener(a);
        btnCreateGame.addActionListener(a);
        btnDeleteGame.addActionListener(a);
        btnHighScore.addActionListener(a);
        btnLogOut.addActionListener(a);
    }

}
