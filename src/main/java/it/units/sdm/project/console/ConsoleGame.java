package it.units.sdm.project.console;

import it.units.sdm.project.Game;
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

public class ConsoleGame extends Game {

    private final Board board;
    private final Player chaosPlayer;
    private final Player orderPlayer;

    public ConsoleGame() {
        board = new Board();
        chaosPlayer = new Player(Player.Role.CHAOS);
        orderPlayer = new Player(Player.Role.ORDER);
    }

    @Override
    public void start() {

        Scanner scanner = new Scanner(System.in);
        String moveLine;
        Player currentPlayer = orderPlayer;

        ConsoleDrawer.print(GameMessages.LOGO);
        ConsoleDrawer.println(GameMessages.WELCOME);
        ConsoleDrawer.print(GameMessages.INTRO);

        //TODO: discuss rigorously the syntax of command line inserted by the user
        do {
            try {
                ConsoleDrawer.print(board);
                ConsoleDrawer.print(currentPlayer.getRole() + " " + GameMessages.MAKE_YOUR_MOVE + " ");
                moveLine = scanner.nextLine();
                MoveParser.setMoveLine(moveLine.trim());
                Move move = new Move(MoveParser.getRaw(), MoveParser.getColumn(), MoveParser.getSymbol());
                currentPlayer.makeMove(move, board);
                changeRole(currentPlayer);
            } catch (IllegalSymbolException | BoardIndexOutOfBoundsException |
                    TakenCellException | WrongNumberOfArgumentsException e) {
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
