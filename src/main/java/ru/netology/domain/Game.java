package ru.netology.domain;

import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> registeredPlayers;

    public Game(ArrayList<Player> registeredPlayers) {
        this.registeredPlayers = registeredPlayers;
    }

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if ((findByName(playerName1) == null) && (findByName(playerName2) == null)) {
            throw new NotRegisteredException("Оба игрока не зарегистрированы");
        }

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегестрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегестрирован");
        }

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String playerName) {

        for (Player registeredPlayer : registeredPlayers) {
            if (registeredPlayer.getName().contains(playerName)) {
                return registeredPlayer;
            }
        }
        return null;

    }




}
