package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by sverreostgaard on 02.12.15.
 * Class: creates the HighScore GUI.
 */
public class HighScore extends JPanel {

    // Declares variables used in the class
    private JTable tableHS;
    private JScrollPane scrollPane;
    private JButton btnBack1;

    /**
     * Constructor: Creates the HighScore panel.
     */
    public HighScore() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        // Creates labels, JTable and buttons, assign them attributes and adds them to the panel.

        JLabel lblHighScore = new JLabel("High Score");
        lblHighScore.setForeground(Color.WHITE);
        lblHighScore.setFont(new Font("Verdana", Font.BOLD, 35));
        lblHighScore.setBounds(200, 70, 300, 50);
        add(lblHighScore);

        tableHS = new JTable();
        scrollPane = new JScrollPane(tableHS);
        scrollPane.setBounds(100, 150, 450, 230);
        add(scrollPane);

        /**
         * Creates btnBack1 and defines the ActionCommand for it (Back1).
         */
        btnBack1 = new JButton("Back");
        btnBack1.setBounds(265, 400, 117, 29);
        btnBack1.setActionCommand("Back1");
        add(btnBack1);

    }

    /**
     * Method: Gets the JTable tableHS.
     */
    public JTable getTableHS() {
        return tableHS;
    }

    /**
     * Method: Adds ActionListener to btnBack1.
     * The parameter a is an object of ActionListener.
     */
    public void HighScoreAL(ActionListener a)
    {
        btnBack1.addActionListener(a);
    }
}
