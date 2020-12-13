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

        //TODO: discuss rigorously the syntax of command line inserted by the user
        do {
            try {
                winnerChecker.setCurrentBoard(board);
                BoardDrawer.print(board);
//              currentPlayer.update();
                System.out.println("What is your next move?");
                command = scanner.nextLine();
                player.makeMove(new Move(command), board);
            } catch (IllegalSymbolException | BoardIndexOutOfBoundsException |
                    TakenCellException | WrongNumberOfArgumentsException e) {
                System.out.print(e.getMessage());
                System.out.println(" Try Again.");
            } catch (NumberFormatException e){
                System.out.println("Bad syntax for the board index. Try again");
            }

        } while (!winnerChecker.thereIsAWinner());

        BoardDrawer.print(board);
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
                break;
        }
    }
}
