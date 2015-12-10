package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;


/**
 * Created by sverreostgaard on 02.12.15.
 */
public class Api {


    private ServerConnect serverConnect;


    public Api()
    {
        serverConnect = new ServerConnect();
    }


    //whenever the login method is called, it must be called with an user object in the parenthesis.
    public String login(User user) {

        String message = "";

        //sends the User object to login method in api in server.
        String data = serverConnect.post(new Gson().toJson(user), "login");
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(data);
            JSONObject jsonobject = (JSONObject) object;

            message = (String)jsonobject.get("message");

            // Gets the user ID to the respective user. If it is not equal to null...
           if (jsonobject.get("userid") != null) {

               //gets the user ID from database and sets it the int variable "id" in the User class.
               user.setId((int)(long) jsonobject.get("userid"));
           }

        } catch (ParseException e) {
            message = "Please insert username and password:";
        }
        return message;
    }



    public ArrayList<User> getUsers()
    {
        String jsonData = serverConnect.get("users/");

        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>() {

        }.getType());

        return users;
    }



    public String JoinGame(Game game)
    {
        String jsonData = serverConnect.put(new Gson().toJson(game), "games/join/");
        return serverConnect.stringMessageParser(jsonData);
    }


    public String StartGame(Game game)
    {
        String jsonData = serverConnect.put(new Gson().toJson(game), "games/start/");
        return serverConnect.stringMessageParser(jsonData);
    }



    public String CreateGame(Game game)
    {
        String jsonData = serverConnect.post(new Gson().toJson(game), "games/");

        return serverConnect.stringMessageParser(jsonData);
    }


    public String DeleteGame(int gameId)
    {
        String jsonData = serverConnect.delete("games/" + gameId);

        return serverConnect.stringMessageParser(jsonData);
    }


    public ArrayList<Score> getHighScore()
    {
        String jsonData = serverConnect.get("highscores/");

        ArrayList<Score> scores = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Score>>(){}.getType());

        return scores;
    }


    public ArrayList<Game> getOpenGames()
    {
        String jsonData = serverConnect.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>(){}.getType());

        return openGames;
    }

}

