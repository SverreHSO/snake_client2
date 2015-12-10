package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created by sverreostgaard on 27.11.15.
 * Class: creates the CreateGame GUI.
 */
public class CreateGame extends JPanel {

    // Declares variables used in the class
    private JLabel lblGameName;
    private JLabel lblGameControls;
    private JTextField textFieldGameName;
    private JTextField textFieldGameControls;
    private JButton btnCreateGame;
    private JButton btnBack3;

    /**
     * Constructor: Creates the CreateGame panel.
     */
    public CreateGame() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        // Creates textfields, labels and buttons, assign them attributes and adds them to the panel.

        JLabel lblCreateGame = new JLabel("Create Game");
        lblCreateGame.setForeground(Color.WHITE);
        lblCreateGame.setFont(new Font("Verdana", Font.BOLD, 35));
        lblCreateGame.setBounds(200, 70, 250, 55);
        add(lblCreateGame);

        lblGameName = new JLabel("Game name");
        lblGameName.setForeground(Color.WHITE);
        lblGameName.setFont(new Font("Verdana", Font.BOLD, 15));
        lblGameName.setBounds(255, 182, 130, 20);
        add(lblGameName);


        textFieldGameName = new JTextField();
        textFieldGameName.setToolTipText("Insert game name");
        textFieldGameName.setFont(new Font("Verdana", Font.PLAIN, 13));
        textFieldGameName.setBounds(255, 210, 140, 30);
        add(textFieldGameName);
        textFieldGameName.setColumns(10);

        lblGameControls = new JLabel("Game controls");
        lblGameControls.setForeground(Color.WHITE);
        lblGameControls.setFont(new Font("Verdana", Font.BOLD, 15));
        lblGameControls.setBounds(255, 252, 130, 20);
        add(lblGameControls);

        textFieldGameControls = new JTextField();
        textFieldGameControls.setToolTipText("Insert your game controls");
        textFieldGameControls.setBounds(255, 280, 140, 30);
        textFieldGameControls.setColumns(10);
        add(textFieldGameControls);

        /**
         * Creates btnCreateGame and defines the ActionCommand for it (Create Game).
         */
        btnCreateGame = new JButton("Create game");
        btnCreateGame.setBounds(265, 320, 117, 29);
        btnCreateGame.setActionCommand("Create Game");
        add(btnCreateGame);

        /**
         * Creates btnBack3 and defines the ActionCommand for it (Back3).
         */
        btnBack3 = new JButton("Back");
        btnBack3.setBounds(265, 400, 117, 29);
        btnBack3.setActionCommand("Back3");
        add(btnBack3);

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
    public String getTextFieldGameName() {
        return textFieldGameName.getText();
    }

    /**
     * Method: converts textFieldGameControls into a String and gets GameControls
     */
    public String getTextFieldGameControls() {
        return textFieldGameControls.getText();
    }

    /**
     * Method: Adds ActionListeners to btnCreateGame and btnBack3.
     * The parameter a is an object of ActionListener.
     */
    public void CreateGameAL(ActionListener a)
    {
        btnCreateGame.addActionListener(a);
        btnBack3.addActionListener(a);
    }

}