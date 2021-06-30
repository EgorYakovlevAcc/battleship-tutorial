package ru.battleship;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private boolean isWinner;
    private List<Ship> ships;
    private Field playerField;
    private Field hitsField;

    public Player(String name) {
        this.name = name;
        this.isWinner = false;
        this.ships = new ArrayList<>();
        this.playerField = new Field();
        this.hitsField = new Field();
    }

    public Field getPlayerField() {
        return playerField;
    }

    public void setPlayerField(Field playerField) {
        this.playerField = playerField;
    }

    public Field getHitsField() {
        return hitsField;
    }

    public void setHitsField(Field hitsField) {
        this.hitsField = hitsField;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
