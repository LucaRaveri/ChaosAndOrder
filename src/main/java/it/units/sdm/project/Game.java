package it.units.sdm.project;

import it.units.sdm.project.drawer.BoardDrawer;
import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Move;
import it.units.sdm.project.entities.Player;

import java.util.Scanner;

public class Game {

    private final Board board;
    private final Player player;
    private final WinnerChecker winnerChecker;

    public Game() {
        board = new Board();
        player = new Player();
        winnerChecker = new WinnerChecker();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            winnerChecker.setCurrentBoard(board);
            BoardDrawer.print(board);
//            currentPlayer.update();
            System.out.println("What is your next move?");
            command = scanner.nextLine();
            player.makeMove(new Move(command), board);
        } while (!winnerChecker.thereIsAWinner());

        printTheWinner(winnerChecker.getWinner());

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
