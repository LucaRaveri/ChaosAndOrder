package it.units.sdm.project.console;

import it.units.sdm.project.entities.*;
import it.units.sdm.project.utils.ConsoleDrawer;
import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;
import it.units.sdm.project.exceptions.TakenCellException;
import it.units.sdm.project.exceptions.WrongNumberOfArgumentsException;
import it.units.sdm.project.utils.GameMessages;
import it.units.sdm.project.utils.MoveParser;
import it.units.sdm.project.utils.WinnerChecker;

import java.util.Scanner;

public class ConsoleGame {

    private final Board board;
    private final Player chaosPlayer;
    private final Player orderPlayer;
    private final Scanner scanner;
    private Role winner;

    public ConsoleGame() {
        board = new Board();
        chaosPlayer = new Player(Role.CHAOS);
        orderPlayer = new Player(Role.ORDER);
        scanner = new Scanner(System.in);
    }

    public void start() {

        String moveLine;
        Player currentPlayer = orderPlayer;

        ConsoleDrawer.print(GameMessages.LOGO);
        ConsoleDrawer.println(GameMessages.WELCOME);
        ConsoleDrawer.print(GameMessages.INTRO);

        //TODO: discuss if it is worth to keep Player class
        do {
            try {
                ConsoleDrawer.print(board);
                ConsoleDrawer.print(currentPlayer.getRole() + " " + GameMessages.MAKE_YOUR_MOVE + " ");
                moveLine = scanner.nextLine();
                MoveParser.setMoveLine(moveLine.trim());
                Move move = new Move(MoveParser.getRaw(), MoveParser.getColumn(), MoveParser.getSymbol());
                currentPlayer.makeMove(move, board);
                changeRole(currentPlayer);
                winner = WinnerChecker.getWinnerRole(board);
            } catch (IllegalSymbolException | BoardIndexOutOfBoundsException |
                    TakenCellException | WrongNumberOfArgumentsException e) {
                ConsoleDrawer.println(e.getMessage() + " " + GameMessages.TRY_AGAIN + "\n");
            }
        } while (winner.isEmpty());

        ConsoleDrawer.print(board);
        ConsoleDrawer.println("\n" + GameMessages.CONGRATULATIONS + " "
                + GameMessages.THE_WINNER_IS + " " + WinnerChecker.getWinnerRole(board) + "\n");
    }

    private void changeRole(Player currentPlayer) {

        currentPlayer.setRole((currentPlayer.getRole() == Role.CHAOS) ? Role.ORDER : Role.CHAOS);

    }


}
