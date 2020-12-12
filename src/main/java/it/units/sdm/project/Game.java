package it.units.sdm.project;

import it.units.sdm.project.drawer.BoardDrawer;
import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Move;
import it.units.sdm.project.entities.Player;

import java.util.Scanner;

public class Game {

    private final Board board;
    private final Player player;

    public Game() {
        board = new Board();
        player = new Player();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            BoardDrawer.print(board);
//            currentPlayer.update();
            System.out.println("What is your next move?");
            command = scanner.nextLine();
            Move move = new Move(command);
            player.makeMove(move, board);
        } while (!WinnerChecker.thereIsAWinner());

        printTheWinner(WinnerChecker.getWinner());

    }

    private void printTheWinner(Player.Role winner) {
        switch (winner) {
            case CHAOS:
                System.out.println("Congratulations CHAOS, you won the game!");
                break;
            case ORDER:
                System.out.println("Congratulations ORDER, you won the game!");
                break;
            default:
                System.out.println("Something went wrong... which is the winner?");

        }
    }
}
