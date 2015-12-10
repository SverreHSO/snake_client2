package sdk;


import java.util.Date;

/**
 * Created by sverreostgaard on 02.12.15.
 */
public class Game {

    private Gamer host, opponent, winner;
    private String name, status;
    private Date created;
    private int gameId, mapSize;

    public Gamer getHost() {
        return host;
    }

    public void setHost(Gamer host) {
        this.host = host;
    }

    public Gamer getOpponent() {
        return opponent;
    }

    public void setOpponent(Gamer opponent) {
        this.opponent = opponent;
    }

    public Gamer getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }
}
