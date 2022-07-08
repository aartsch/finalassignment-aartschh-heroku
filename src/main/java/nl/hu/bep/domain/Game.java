package nl.hu.bep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private String id;
    private int turn;
    private static List<Game> allGames = new ArrayList<>();

    public Game(String id) {
        this.id = id;

        if (!allGames.contains(this)) allGames.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getId() {
        return id;
    }

    public static List<String> getIdsFromAllGames() {
        List<String> gameIds = new ArrayList<>();

        for (Game g : allGames) {
            gameIds.add(g.getId());
        }
        return gameIds;
    }

    public static boolean removeGame(String id) {
        return allGames.removeIf(game -> game.getId().equals(id));
    }

    public static String getGameDetailsById(String id) {
        Game game1 = allGames.stream()
                .filter(game -> id.equals(game.getId()))
                .findAny()
                .orElse(null);

        assert game1 != null;
        return game1.getId() + " " + game1.getTurn();
    }

}
