package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by sverreostgaard on 27.11.15.
 * Class: Creates the JFrame and adds all the panels to it (LogIn, SignUp, Menu, JoinGame, CreateGame, DeleteGame and HighScore).
 */
public class Screen extends JFrame {


    /**
     * Creates final strings which is the calling cards for the different panels.
     */
    public static final String LOG_IN = "Log In";
    public static final String MENU = "Menu";
    public static final String JOIN_GAME = "Join Game";
    public static final String CREATE_GAME = "Create Game";
    public static final String DELETE_GAME = "Delete Game";
    public static final String HIGH_SCORE = "High Score";
    public static final String SIGN_UP = "Sign Up";

    // Declares variables used in the class
    private JPanel contentPane;
    private LogIn login;
    private Menu menu;
    private JoinGame joingame;
    private CreateGame creategame;
    private DeleteGame deletegame;
    private HighScore highscore;
    private SignUp signup;
    private CardLayout cl;

    /**
     * Constructor: Creates the Screen panel.
     */
    public Screen() {
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 650, 500);

        // Creates the main panel.
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
        contentPane.setLayout(new CardLayout(1, 1));

        // Creates an object of all the panels (LogIn, Menu...) and then adds them to the contentPane (the main panel).
        login = new LogIn();
        contentPane.add(login, LOG_IN);
        signup = new SignUp();
        contentPane.add(signup, SIGN_UP);
        menu = new Menu();
        contentPane.add(menu, MENU);
        joingame = new JoinGame();
        contentPane.add(joingame, JOIN_GAME);
        creategame = new CreateGame();
        contentPane.add(creategame, CREATE_GAME);
        deletegame = new DeleteGame();
        contentPane.add(deletegame, DELETE_GAME);
        highscore = new HighScore();
        contentPane.add(highscore, HIGH_SCORE);


        cl = (CardLayout) contentPane.getLayout();

        // Adds the main panel to the JFrame and makes it visible.
        jframe.add(contentPane);
        jframe.setVisible(true);

    }



    /**
     * Get-methods for the main panel, cl and all the other panels.
     */
    public JPanel getContentPane() {
        return contentPane;
    }

    public CardLayout getCl() {
        return cl;
    }

    public LogIn getLogin() {
        return login;
    }

    public Menu getMenu() {
        return menu;
    }

    public JoinGame getJoingame() {
        return joingame;
    }

    public CreateGame getCreategame() {
        return creategame;
    }

    public DeleteGame getDeletegame() {
        return deletegame;
    }

    public HighScore getHighscore() {
        return highscore;
    }

    public SignUp getSignup() {
        return signup;
    }


}
