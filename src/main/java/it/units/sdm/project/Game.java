package it.units.sdm.project;

import it.units.sdm.project.drawers.BoardDrawer;
import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Move;
import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.WinnerChecker;
import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;
import it.units.sdm.project.exceptions.TakenCellException;
import it.units.sdm.project.exceptions.WrongNumberOfArgumentsException;

import java.util.Scanner;

public class Game {

    private final Board board;
    private final Player chaosPlayer;
    private final Player orderPlayer;
    private final WinnerChecker winnerChecker;

    public Game() {
        board = new Board();
        chaosPlayer = new Player(Player.Role.CHAOS);
        orderPlayer = new Player(Player.Role.ORDER);
        winnerChecker = new WinnerChecker();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        String command;
        Player currentPlayer = orderPlayer;

        //TODO: discuss rigorously the syntax of command line inserted by the user
        do {
            try {
                winnerChecker.setCurrentBoard(board);
                System.out.println("Player " + currentPlayer.getRole() + " make your move");
                BoardDrawer.print(board);
                command = scanner.nextLine();
                currentPlayer.makeMove(new Move(command), board);
                changeRole(currentPlayer);
            } catch (IllegalSymbolException | BoardIndexOutOfBoundsException |
                    TakenCellException | WrongNumberOfArgumentsException e) {
                System.out.print(e.getMessage());
                System.out.println(" Try Again.");
            } catch (NumberFormatException e) {
                System.out.println("Bad syntax for the board index. Try again");
            }

        } while (!winnerChecker.thereIsAWinner());

        BoardDrawer.print(board);
        System.out.println("Congratulation to the player that has the role " + winnerChecker.getWinnerRole() + "!");
    }

    private void changeRole(Player currentPlayer) {

        currentPlayer.setRole(( currentPlayer.getRole() == Player.Role.CHAOS)? Player.Role.ORDER: Player.Role.CHAOS);

    }


}
