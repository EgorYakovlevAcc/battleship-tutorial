package ru.battleship.part2;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String name;
    private Set<Ship> ships;
    private Field playerField;
    private Field hitsField;

    public Player(String name) {
        this.name = name;
        this.ships = new HashSet<>();
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

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLoser() {
        return getAmountOfAliveShips() == 0;
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
}
