package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by sverreostgaard on 27.11.15.
 * Class: creates the DeleteGame GUI.
 */
public class DeleteGame extends JPanel {

    // Declares variables used in the class
    private JTextField textGameToDelete;
    private JButton btnDelete;
    private JButton btnBack2;
    private int gameToDelete;


    /**
     * Constructor: Creates the DeleteGame panel.
     */
    public DeleteGame() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        // Creates labels, textfields and buttons, assign them attributes and adds them to the panel.

        JLabel lblDeleteGame = new JLabel("Delete Game");
        lblDeleteGame.setForeground(Color.WHITE);
        lblDeleteGame.setBounds(210, 100, 300, 50);
        lblDeleteGame.setFont(new Font("Verdana", Font.BOLD, 35));
        add(lblDeleteGame);

        JLabel lblGameToDelete = new JLabel("Insert gameID to the game you wish to delete:");
        lblGameToDelete.setForeground(Color.WHITE);
        lblGameToDelete.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblGameToDelete.setBounds(145, 202, 360, 20);
        add(lblGameToDelete);

        textGameToDelete = new JTextField();
        textGameToDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
        textGameToDelete.setBounds(255, 230, 140, 30);
        textGameToDelete.setColumns(10);
        add(textGameToDelete);

        /**
         * Creates btnDelete and defines the ActionCommand for it (Delete Game).
         */
        btnDelete = new JButton("Delete game");
        btnDelete.setBounds(265, 270, 117, 29);
        btnDelete.setActionCommand("Delete Game");
        add(btnDelete);

        /**
         * Creates btnBack2 and defines the ActionCommand for it (Back2).
         */
        btnBack2 = new JButton("Back");
        btnBack2.setBounds(265, 400, 117, 29);
        btnBack2.setActionCommand("Back2");
        add(btnBack2);

    }


    /**
     * Method: converts textGameToDelete into String, and then into an integer and gets gameToDelete.
     */
    public int getGameToDelete() {
        String gTD = textGameToDelete.getText();
        gameToDelete = Integer.parseInt(gTD);
        return gameToDelete;
    }

    /**
     * Method: sets the text in textGameToDelete to blank/nothing. ie. clearing the text.
     */
    public void ClearText()
    {
     textGameToDelete.setText("");
    }

    /**
     * Method: Adds ActionListeners to btnDelete and btnBack2.
     * The parameter a is an object of ActionListener.
     */
    public void DeleteGameAL(ActionListener a)
    {
        btnDelete.addActionListener(a);
        btnBack2.addActionListener(a);
    }
}
