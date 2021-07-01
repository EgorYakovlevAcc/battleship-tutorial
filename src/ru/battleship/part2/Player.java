package ru.battleship.part2;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Ship> ships;
    private Field playerField;
    private Field hitsField;

    public Player(String name) {
        this.name = name;
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

    public int getAmountOfAliveShips() {
        int counter = 0;
        for (Ship ship: this.getShips()) {
            if (ship.isAlive()) {
                counter++;
            }
        }
        return counter;
    }

    public boolean isLoser() {
        return getAmountOfAliveShips() == 0;
    }
}
