package ru.battleship.part2;

import java.util.HashSet;
import java.util.Set;

public class Field {
    private static final Integer FIELD_SIZE = 10;
    private Set<Cell> cells;

    public Field() {
        this.cells = initFields();
    }

    private Set<Cell> initFields() {
        Set<Cell> cells = new HashSet<>();
        for (int i = 0; i <= FIELD_SIZE * FIELD_SIZE; i++) {
            cells.add(new Cell(i % FIELD_SIZE + 1, i / FIELD_SIZE + 1));
        }
        return cells;
    }

    public void addShip(Ship ship) {
        this.cells.removeAll(ship.getDecks());
        this.cells.addAll(ship.getDecks());
    }

    public Cell getCellByCoords(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }

    public Status handleShot(int xShot, int yShot) {
        Cell cell = getCellByCoords(xShot, yShot);
        Ship shipReference = cell.getShip();
        if (shipReference != null) {
            cell.setStatus(Status.HIT);
            return Status.HIT;
        }
        cell.setStatus(Status.MISS);
        return Status.MISS;
    }

    private boolean isAnyShipAroundCell(Cell cell) {
        return !(isCellFree(cell.getX(), cell.getY())
                && isCellFree(cell.getX() + 1, cell.getY() + 1)
                && isCellFree(cell.getX() + 1, cell.getY())
                && isCellFree(cell.getX(), cell.getY() + 1)
                && isCellFree(cell.getX(), cell.getY() - 1)
                && isCellFree(cell.getX() - 1, cell.getY() - 1)
                && isCellFree(cell.getX() - 1, cell.getY() + 1)
                && isCellFree(cell.getX() - 1, cell.getY())
                && isCellFree(cell.getX() + 1, cell.getY() - 1));
    }

    private boolean isCellFree(int x, int y) {
        Cell cell = this.getCellByCoords(x, y);
        if (cell != null) {
            return cell.getStatus().equals(Status.FREE);
        }
        return true;
    }

    public boolean validateShipLocation(Ship ship) {
        for (Cell cell : ship.getDecks()) {
            if (cell.getX() < 1 || cell.getX() > FIELD_SIZE || cell.getY() < 1 || cell.getY() > FIELD_SIZE) {
                return false;
            }
        }
        for (Cell cell : ship.getDecks()) {
            if (isAnyShipAroundCell(cell)) {
                return false;
            }
        }
        return true;
    }

    public String printField() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= FIELD_SIZE; i++) {
            for (int q = 1; q <= FIELD_SIZE; q++) {
                Cell cell = getCellByCoords(q, i);
                sb.append("|");
                sb.append(cell.getStatus().getPicture());
                sb.append("|");
            }
            sb.append("\n");
            for (int k = 0; k < FIELD_SIZE; k++) {
                sb.append("---");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
