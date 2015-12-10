package logic;

import com.google.gson.Gson;
import gui.Screen;
import sdk.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by sverreostgaard on 27.11.15.
 * Class: Logic handles the logic of this application. It is the layer between frontend (GUI) and backend(SDK)
 */
public class Logic {

    // Declares variables used in the class
    private Screen screen;
    private ServerConnect serverConnect;
    private User currentUser;
    private Api api;


    public Logic()
    {
        screen = new Screen();
        serverConnect = new ServerConnect();
        currentUser = new User();
        api = new Api();
    }


    public void run()
    {
        screen.getLogin().LogInAL(new LoginActionListener());
        screen.getMenu().MenuAL(new MenuActionListener());
        screen.getJoingame().JoinGameAL(new JoinGameActionListener());
        screen.getCreategame().CreateGameAL(new CreateGameActionListener());
        screen.getDeletegame().DeleteGameAL(new DeleteGameActionListener());
        screen.getHighscore().HighScoreAL(new HighScoreActionListener());
        screen.getSignup().SignUpAL(new SignUpActionListener());

    }




    public class LoginActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();


            // Assigns the username and password inserted in the GUI (login) to currentUser.
            currentUser.setUsername(screen.getLogin().getUserName());
            currentUser.setPassword(screen.getLogin().getPassword());


            //
            String messageFromLoginApi = api.login(currentUser);
            if (messageFromLoginApi.equals("Login successful"))
            {
                JOptionPane.showMessageDialog(screen, messageFromLoginApi, "Login", 1, new ImageIcon(Logic.class.getResource("/png/snakeicon.png")));
                screen.getCl().show(screen.getContentPane(), screen.MENU);
                //Clears text from JTextFild and PasswordField in login so they wont be there when you log out.
                screen.getLogin().ClearText();
                screen.getMenu().Information(currentUser.getUsername(), currentUser.getId());
            }
            else if (action.equals("Sign Up"))
            {
                screen.getCl().show(screen.getContentPane(), screen.SIGN_UP);
            }

        }

    }





    public class MenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if(action.equals("Join Game")){
                screen.getCl().show(screen.getContentPane(), screen.JOIN_GAME);
            }
            else if(action.equals("Create Game")){
                screen.getCl().show(screen.getContentPane(), screen.CREATE_GAME);
            }
            else if(action.equals("Delete Game")){
                screen.getCl().show(screen.getContentPane(), screen.DELETE_GAME);
            }
            else if(action.equals("High Score")){
                hsTabel();
                screen.getCl().show(screen.getContentPane(), screen.HIGH_SCORE);
            }
            else if(action.equals("Log Out")){
                screen.getCl().show(screen.getContentPane(), screen.LOG_IN);
                screen.getMenu().ClearInfo();
            }
            else{
                screen.getCl().show(screen.getContentPane(), screen.MENU);
            }

        }

    }






    public class JoinGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action.equals("Join Game"))
            {
                JoinGame();
                screen.getJoingame().ClearText();
            }
            else if (action.equals("Back"))
            {
                screen.getCl().show(screen.getContentPane(), screen.MENU);
                screen.getJoingame().ClearText();
            }

        }

    }

    public String JoinGame()
    {
        if (!screen.getJoingame().getGameName().equals("") && !screen.getJoingame().getGameControls().equals(""))
        {

            Gamer opponent = new Gamer();
            opponent.setId(currentUser.getId());
            opponent.setControls(screen.getJoingame().getGameControls());

            Game game = new Game();
            game.setOpponent(opponent);

            // game is the opponents new game, while games are the allready open game that the opponent is trying to join
            for (Game games : api.getOpenGames())
            {
                if (games.getName().equals(screen.getJoingame().getGameName()))
                {
                    game.setGameId(games.getGameId());
                }

            }

            String messageFromJoin = api.JoinGame(game);
            api.StartGame(game);


            System.out.println("Game was joined");
            return messageFromJoin;


        }
        else
        System.out.println("Something went wrong");
        return "";
    }




    public class CreateGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action.equals("Create Game"))
            {
                CreateNewGame();
                screen.getCreategame().ClearText();
            }

            else if (action.equals("Back3"))
            {
                screen.getCl().show(screen.getContentPane(), screen.MENU);
                screen.getCreategame().ClearText();
            }

        }

    }




    public String CreateNewGame()
    {

        if (!screen.getCreategame().getTextFieldGameName().equals("") && !screen.getCreategame().getTextFieldGameControls().equals(""))
        {


            Gamer host = new Gamer();
            host.setId(currentUser.getId());
            host.setControls(screen.getCreategame().getTextFieldGameControls());


            Game game = new Game();
            game.setName(screen.getCreategame().getTextFieldGameName());
            game.setHost(host);
            game.setMapSize(200);

            String messageFromCreateApi = api.CreateGame(game);

            for (Game g : api.getOpenGames())
            {
                if (g.getName().equals(screen.getCreategame().getTextFieldGameName()))
                {
                    game.setGameId(g.getGameId());
                }
            }

            JOptionPane.showMessageDialog(screen, messageFromCreateApi);
            return messageFromCreateApi;
        }
        else

            JOptionPane.showMessageDialog(screen, "something went wrong");

        return "";
    }




    public class DeleteGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action.equals("Delete Game"))
            {
                deleteGame();
            }
            else if (action.equals("Back2"))
            {
                screen.getCl().show(screen.getContentPane(), screen.MENU);
                screen.getDeletegame().ClearText();
            }

        }

    }





    public String deleteGame()
    {
        int gameToDelete = screen.getDeletegame().getGameToDelete();

        String message = api.DeleteGame(gameToDelete);
        JOptionPane.showMessageDialog(screen, message, "Delete game", 1, new ImageIcon(Logic.class.getResource("/png/snakeicon.png")));

        System.out.println(message);

        if (message.equals("Game was deleted"))
        {
            System.out.println("Game was deleted");
        }
        else if (message.equals("Failed. Game was not deleted"))
        {
            System.out.println("Game was not deleted");
        }
        else
        {
            System.out.println("Something went wrong");
        }

        return message;
    }





    public class HighScoreActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action.equals("Back1"))
            {
                screen.getCl().show(screen.getContentPane(), screen.MENU);
            }

        }

    }





    public class HighScoreTableModel extends AbstractTableModel
    {
        private static final long serialVersionUID = 1L;

        private String[] columnNames = {"Game ID", "Name", "Score"};
        private int nrOfRows;
        private ArrayList<Score> highScores;


        public HighScoreTableModel(ArrayList<Score> highScores)
        {
            this.highScores = highScores;
            fireTableStructureChanged();
        }


        @Override
        public int getRowCount() {
            nrOfRows = highScores.size();
            return nrOfRows;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return super.getColumnClass(columnIndex);
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            switch (columnIndex)
            {
                case 0:
                    return highScores.get(rowIndex).getGame().getGameId();
                case 1:
                    return highScores.get(rowIndex).getGame().getWinner().getUsername();
                case 2:
                    return highScores.get(rowIndex).getScore();
            }
            return null;
        }

    }




    public void hsTabel()
    {
        ArrayList<Score> scores = api.getHighScore();
        HighScoreTableModel hsTableModel = new HighScoreTableModel(scores);
        screen.getHighscore().getTableHS().setModel(hsTableModel);
    }





    public class SignUpActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if(action.equals("Sign Up1")){
                CreateUser();
                screen.getCl().show(screen.getContentPane(), screen.LOG_IN);
                screen.getSignup().ClearText();
            }
            else if(action.equals("Back4")) {
                screen.getCl().show(screen.getContentPane(), screen.LOG_IN);
                screen.getSignup().ClearText();
            }
            else {
                screen.getCl().show(screen.getContentPane(), screen.LOG_IN);
            }

        }

    }




    public boolean CreateUser()
    {
        String firstName = screen.getSignup().getTextFieldFirstName();
        String lastName = screen.getSignup().getTextFieldLastName();
        String userName = screen.getSignup().getTextFieldUsername();
        String password = screen.getSignup().getTextFieldPassword();
        String email = screen.getSignup().getTextFieldEmail();
        int type = 1;

        if (!firstName.equals("") && !lastName.equals("") && !userName.equals("") && !password.equals("") && !email.equals(""))
        {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setType(type);

            String json = new Gson().toJson(user);

            String message = serverConnect.stringMessageParser(serverConnect.post(json, "users/"));
            System.out.println(message);

            if (message.equals("User was created"))
            {
                JOptionPane.showMessageDialog(screen, message);
                return true;
            }
            else if (message.equals("Username or email already exists"))
            {
                JOptionPane.showMessageDialog(screen, message);
            }
            else if (message.equals("Error in JSON"))
            {
                JOptionPane.showMessageDialog(screen, message);
            }
        }

        return false;
    }

}