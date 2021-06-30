package ru.battleship;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Battleship {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Player 1, please, input your name");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name);

        System.out.println("Player 2, please, input your name");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name);

        fillPlayerField(player1);
        fillPlayerField(player2);

        playGame(player1, player2);
    }

    static void playGame(Player player1, Player player2) {
        Player currentPlayer = player1;
        Player opponentPlayer = player2;
        while (!player1.isWinner() || !player2.isWinner()) {
            System.out.println(currentPlayer.getName() + ", please, input x coord of shot");
            int xShot = scanner.nextInt();
            System.out.println(currentPlayer.getName() + ", please, input y coord of shot");
            int yShot = scanner.nextInt();

            Status cellStatus = opponentPlayer.getPlayerField().handleShot(xShot, yShot);
            Cell cell = currentPlayer.getHitsField().getCellByCoords(xShot, yShot);
            cell.setStatus(cellStatus);

            if (Status.HIT.equals(cellStatus)) {
                if (!opponentPlayer.getPlayerField().getCellByCoords(xShot, yShot).getShip().isAlive()) {
                    System.out.println("Good short! You have killed a ship.");
                } else {
                    System.out.println("Good short!");
                }
            } else {
                currentPlayer = player2;
                opponentPlayer = player1;
                System.out.println("Bad short :(");
            }
        }
    }

    static void fillPlayerField(Player player) {
        for (Map.Entry<Integer, Integer> shipTypeAmount : getShipTypeAmountMap().entrySet()) {
            for (int i = 0; i < shipTypeAmount.getValue(); i++) {
                System.out.println("Расставляем " + shipTypeAmount.getKey() + "-палубный корабль. Осталось расставить: " + (shipTypeAmount.getValue() - i));

                System.out.println("Input x coord: ");
                int x = scanner.nextInt();

                System.out.println("Input y coord: ");
                int y = scanner.nextInt();

                System.out.println("1 - horizontal; 2 - vertical ?");
                int position = scanner.nextInt();

                Ship ship = new Ship(x, y, position, shipTypeAmount.getKey());
                player.getShips().add(ship);
                player.getPlayerField().addShip(ship);

                System.out.println(player.getPlayerField().printField());
            }
        }
    }

    private static Map<Integer, Integer> getShipTypeAmountMap() {
        Map<Integer, Integer> shipTypeAmountMap = new LinkedHashMap<>();
        shipTypeAmountMap.put(4, 1);
        shipTypeAmountMap.put(3, 2);
        shipTypeAmountMap.put(2, 3);
        shipTypeAmountMap.put(1, 4);
        return shipTypeAmountMap;
    }
}

