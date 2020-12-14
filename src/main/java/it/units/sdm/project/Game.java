package it.units.sdm.project;

import it.units.sdm.project.utils.ConsoleDrawer;
import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Move;
import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.WinnerChecker;
import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;
import it.units.sdm.project.exceptions.TakenCellException;
import it.units.sdm.project.exceptions.WrongNumberOfArgumentsException;
import it.units.sdm.project.utils.GameMessages;

import java.util.Scanner;

public class Game {

    private final Board board;
    private final Player chaosPlayer;
    private final Player orderPlayer;

    public Game() {
        board = new Board();
        chaosPlayer = new Player(Player.Role.CHAOS);
        orderPlayer = new Player(Player.Role.ORDER);
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        String command;
        Player currentPlayer = orderPlayer;

        ConsoleDrawer.print(GameMessages.LOGO);
        ConsoleDrawer.println(GameMessages.WELCOME);
        ConsoleDrawer.println(GameMessages.INTRO);

        //TODO: discuss rigorously the syntax of command line inserted by the user
        do {
            try {
                ConsoleDrawer.print(board);
                ConsoleDrawer.print(currentPlayer.getRole() + " " + GameMessages.MAKE_YOUR_MOVE + " ");
                command = scanner.nextLine();
                currentPlayer.makeMove(new Move(command), board);
                changeRole(currentPlayer);
            } catch (IllegalSymbolException | BoardIndexOutOfBoundsException |
                    TakenCellException | WrongNumberOfArgumentsException |
                    NumberFormatException e) {
                ConsoleDrawer.println(e.getMessage() + " " + GameMessages.TRY_AGAIN + "\n");
            }
        } while (!WinnerChecker.thereIsAWinner(board));

        ConsoleDrawer.print(board);
        ConsoleDrawer.println("\n" + GameMessages.CONGRATULATIONS + " "
                + GameMessages.THE_WINNER_IS + " " + WinnerChecker.getWinnerRole(board) + "\n");
    }

    private void changeRole(Player currentPlayer) {

        currentPlayer.setRole((currentPlayer.getRole() == Player.Role.CHAOS) ? Player.Role.ORDER : Player.Role.CHAOS);

    }


}
