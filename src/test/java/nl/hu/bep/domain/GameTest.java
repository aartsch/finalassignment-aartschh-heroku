package nl.hu.bep.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("Get correct amount of game ids")
    public void getAllGameIds() {
        new Game("test1");
        new Game("test2");
        new Game("test3");

        List<String> games = new ArrayList<>();

        games.add("test1");
        games.add("test2");
        games.add("test3");


        assertEquals(games, Game.getIdsFromAllGames());
    }

    @Test
    @DisplayName("Is the amount of ids correct")
    public void getCorrectGameIdsAmount() {
        new Game("test1");
        new Game("test2");
        new Game("test3");

        List<String> games = new ArrayList<>();

        games.add("test1");
        games.add("test2");
        games.add("test3");


        assertEquals(games.size(), Game.getIdsFromAllGames().size());
    }

    @Test
    @DisplayName("games get added to allGames list")
    public void addGame() {
        Game game1 = new Game("test1");

        assertEquals(game1, Game.getAllGames().get(0));
    }

    @Test
    @DisplayName("does the game not exist anymore when the game is removed")
    public void removeGame() {
        Game game1 = new Game("test1");

        Game.removeGame("test1");


        assertFalse(Game.getAllGames().contains(game1));
    }

    @Test
    @DisplayName("get game details returns the right details of a game")
    public void getGameDetails() {
        new Game("test1");

        assertEquals("test1" + " " + 0 + " " + null, Game.getGameDetailsById("test1") );
    }
}