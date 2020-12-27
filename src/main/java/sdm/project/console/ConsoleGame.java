package sdm.project.console;

import sdm.project.entities.Board;
import sdm.project.entities.Move;
import sdm.project.entities.Player;
import sdm.project.exceptions.BoardIndexOutOfBoundsException;
import sdm.project.exceptions.IllegalSymbolException;
import sdm.project.exceptions.TakenCellException;
import sdm.project.exceptions.WrongNumberOfArgumentsException;
import sdm.project.utils.ConsoleDrawer;
import sdm.project.utils.GameMessages;
import sdm.project.utils.MoveParser;
import sdm.project.utils.WinnerChecker;

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
                ConsoleDrawer.println(board);
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

        ConsoleDrawer.println(board);
        //TODO: avoid WinnerChecker.getWinnerRole(board), is expansive
        if(WinnerChecker.getWinnerRole(board)==Player.CHAOS){
                ConsoleDrawer.println(GameMessages.CHAOS_WINS);
        } else{
                ConsoleDrawer.println(GameMessages.ORDER_WINS);
        }
//        ConsoleDrawer.println("\n" + GameMessages.CONGRATULATIONS + " "
//                + GameMessages.THE_WINNER_IS + " " + WinnerChecker.getWinnerRole(board) + "\n");
    }


}
