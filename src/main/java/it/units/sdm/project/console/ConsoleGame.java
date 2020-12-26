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
    private Player currentPlayer;

    public ConsoleGame() {
        board = new Board();
        currentPlayer = Player.ORDER;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                ConsoleDrawer.print(board);
                ConsoleDrawer.print(currentPlayer.name() + " " + GameMessages.MAKE_YOUR_MOVE + " ");
                MoveParser.setMoveLine(scanner.nextLine());
                Move move = new Move(MoveParser.getRow(), MoveParser.getColumn(), MoveParser.getSymbol());
                board.insert(move);
                currentPlayer = (currentPlayer == Player.CHAOS) ? Player.ORDER : Player.CHAOS;
            } catch (IllegalSymbolException | BoardIndexOutOfBoundsException |
                    TakenCellException | WrongNumberOfArgumentsException e) {
                ConsoleDrawer.println(e.getMessage() + " " + GameMessages.TRY_AGAIN + "\n");
            }
        } while (WinnerChecker.getWinnerRole(board) == null);

        ConsoleDrawer.print(board);
        //TODO: avoid WinnerChecker.getWinnerRole(board), is expansive
        ConsoleDrawer.println("\n" + GameMessages.CONGRATULATIONS + " "
                + GameMessages.THE_WINNER_IS + " " + WinnerChecker.getWinnerRole(board) + "\n");
    }


}
