package ru.battleship;

import java.util.Objects;

public class Cell {
    private int x;
    private int y;
    private Status status;
    private Ship ship;

    public Cell() {
        this.status = Status.FREE;
        this.ship = null;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = Status.FREE;
        this.ship = null;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return getX() == cell.getX() &&
                getY() == cell.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
