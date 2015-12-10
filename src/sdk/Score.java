package sdk;

/**
 * Created by sverreostgaard on 04.12.15.
 */
public class Score {

    private int id, score;
    private Gamer user, opponent;
    private Game game;

    public Score(int id, int score, Gamer user, Gamer opponent, Game game)
    {
        this.id = id;
        this.score = score;
        this.user = user;
        this.opponent = opponent;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Gamer getUser() {
        return user;
    }

    public void setUser(Gamer user) {
        this.user = user;
    }

    public Gamer getOpponent() {
        return opponent;
    }

    public void setOpponent(Gamer opponent) {
        this.opponent = opponent;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
