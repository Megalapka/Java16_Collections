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
        Player name1 = findByName(playerName1);
        Player name2 = findByName(playerName2);


        if ((name1 == null) && (name2 == null)) {
            throw new NotRegisteredException("Оба игрока не зарегистрированы");
        }

        if (name1 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегестрирован");
        }
        if (name2 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегестрирован");
        }

        if (name1.getStrength() > name2.getStrength()) {
            return 1;
        } else if (name1.getStrength() < name2.getStrength()) {
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
