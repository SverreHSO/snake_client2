package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by sverreostgaard on 27.11.15.
 * Class: creates the CreateGame GUI.
 */
public class JoinGame extends JPanel {

    // Declares variables used in the class
    private JLabel lblGameName;
    private JLabel lblGameControls;
    private JTextField textFieldGameName;
    private JTextField textFieldGameControls;
    private JButton btnJoinGame;
    private JButton btnBack;

    /**
     * Constructor: Creates the JoinGame panel.
     */
    public JoinGame() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        // Creates textfields, labels and buttons, assign them attributes and adds them to the panel.

        JLabel lblNewGame = new JLabel("Join Game");
        lblNewGame.setForeground(Color.WHITE);
        lblNewGame.setBounds(200, 100, 300, 50);
        lblNewGame.setFont(new Font("Verdana", Font.BOLD, 35));
        add(lblNewGame);

        lblGameName = new JLabel("Game name:");
        lblGameName.setForeground(Color.WHITE);
        lblGameName.setFont(new Font("Verdana", Font.BOLD, 15));
        lblGameName.setBounds(255, 182, 120, 20);
        add(lblGameName);

        textFieldGameName = new JTextField();
        textFieldGameName.setToolTipText("Insert game you want to join");
        textFieldGameName.setFont(new Font("Verdana", Font.PLAIN, 13));
        textFieldGameName.setBounds(255, 210, 140, 30);
        textFieldGameName.setColumns(10);
        add(textFieldGameName);

        lblGameControls = new JLabel("Game controls:");
        lblGameControls.setForeground(Color.WHITE);
        lblGameControls.setFont(new Font("Verdana", Font.BOLD, 15));
        lblGameControls.setBounds(255, 252, 130, 20);
        add(lblGameControls);

        textFieldGameControls = new JTextField();
        textFieldGameControls.setToolTipText("Insert your moves");
        textFieldGameControls.setBounds(255, 280, 140, 30);
        textFieldGameControls.setColumns(10);
        add(textFieldGameControls);

        /**
         * Creates btnJoinGame and defines the ActionCommand for it (Join Game).
         */
        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(260, 320, 120, 30);
        btnJoinGame.setActionCommand("Join Game");
        add(btnJoinGame);

        /**
         * Creates btnBack and defines the ActionCommand for it (Back).
         */
        btnBack = new JButton("Back");
        btnBack.setBounds(260, 400, 120, 30);
        btnBack.setActionCommand("Back");
        add(btnBack);

    }

    /**
     * Method: sets the text in textFieldGameName and textFieldGameControls to blank/nothing. ie. clearing the text.
     */
    public void ClearText(){
        textFieldGameName.setText("");
        textFieldGameControls.setText("");
    }

    /**
     * Method: converts textFieldGameName into a String and gets GameName
     */
    public String getGameName() {
        return textFieldGameName.getText();
    }

    /**
     * Method: converts textFieldGameControls into a String and gets GameControls
     */
    public String getGameControls() {
        return textFieldGameControls.getText();
    }

    /**
     * Method: Adds ActionListeners to btnJoinGame and btnBack.
     * The parameter a is an object of ActionListener.
     */
    public void JoinGameAL(ActionListener a)
    {
        btnJoinGame.addActionListener(a);
        btnBack.addActionListener(a);
    }

}
