package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;

public class GameTest {
    Player player1 = new Player(1, "player1", 10);
    Player player2 = new Player(2, "player2", 6);
    Player player3 = new Player(3, "player3", 9);
    Player player4 = new Player(4, "player4", 10);
    Player player5 = new Player(5, "player5", 3);
    Player player6 = new Player(6, "player6", 1);
    Player player7 = new Player(7, "player7", 8);
    Player player8 = new Player(8, "player8", 9);
    ArrayList<Player> players = new ArrayList<>();

    Game game = new Game(players);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
    }

    @Test
    public void shouldWinFirstPlayer() {
        int actual = game.round("player2", "player3");
        assertEquals(2, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        int actual = game.round("player1", "player5");
        assertEquals(1, actual);
    }

    @Test
    public void shouldDeadHeat() {
        int actual = game.round("player3", "player8");
        assertEquals(0, actual);
    }

    @Test
    public void shouldExceptionForFirstPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("player9", "player2");
        });
    }

    @Test
    public void shouldExceptionForSecondPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("player1", "player10");
        });
    }

    @Test
    public void shouldExceptionForBothPlayers() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("player11", "player10");
        });
    }


}
