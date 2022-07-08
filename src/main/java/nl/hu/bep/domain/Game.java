package nl.hu.bep.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String id;
    private static List<Game> allGames = new ArrayList<>();

    public Game(String id) {
        this.id = id;

        if (!allGames.contains(this)) allGames.add(this);
    }

    public String getId() {
        return id;
    }

    public void setId(int String) {
        this.id = id;
    }



    public static List<String> getIdsFromAllGames() {
        List<String> gameIds = new ArrayList<>();

        for(Game g : allGames) {
            gameIds.add(g.getId());
        }
        return gameIds;
    }
}
