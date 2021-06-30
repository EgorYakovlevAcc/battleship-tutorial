package ru.battleship;

import java.util.HashSet;
import java.util.Set;

public class Ship {
    private Set<Cell> decks;

    public Ship(int xStart, int yStart, int position, int shipType) {
        this.decks = fillCells(xStart, yStart, position, shipType);
    }

    public boolean isAlive() {
        for (Cell cell: this.decks) {
            if (Status.SHIP.equals(cell.getStatus())) {
                return true;
            }
        }
        return false;
    }

    public Set<Cell> getDecks() {
        return decks;
    }

    public void setDecks(Set<Cell> decks) {
        this.decks = decks;
    }

    private Set<Cell> fillCells(int xStart, int yStart, int position, int shipType) {
        Set<Cell> cells = new HashSet<>();
        for (int step = 0; step < shipType; step++) {
            Cell cell = new Cell();
            if (position == 1) {
                cell.setX(xStart + step);
                cell.setY(yStart);
            } else {
                cell.setX(xStart);
                cell.setY(yStart + step);
            }
            cell.setStatus(Status.SHIP);
            cell.setShip(this);
            cells.add(cell);
        }
        return cells;
    }
}
