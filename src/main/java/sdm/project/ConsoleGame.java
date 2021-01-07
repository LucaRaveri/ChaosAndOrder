package sdm.project;

import sdm.project.core.entities.Board;
import sdm.project.core.entities.Player;
import sdm.project.core.exceptions.BoardIndexOutOfBoundsException;
import sdm.project.core.exceptions.IllegalSymbolException;
import sdm.project.core.exceptions.TakenCellException;
import sdm.project.core.exceptions.WrongNumberOfArgumentsException;
import sdm.project.consolecomponents.ConsoleDrawer;
import sdm.project.core.utils.GameMessages;
import sdm.project.consolecomponents.MoveParser;
import sdm.project.core.utils.WinnerChecker;

import java.util.Scanner;

public class ConsoleGame {

    private final Board board;
    private Player currentPlayer;
    private final MoveParser moveParser;

    public ConsoleGame() {
        board = new Board();
        currentPlayer = Player.ORDER;
        moveParser = new MoveParser();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                ConsoleDrawer.println(board);
                ConsoleDrawer.print(currentPlayer.name() + " " + GameMessages.MAKE_YOUR_MOVE + " ");
                moveParser.setMoveLine(scanner.nextLine());
                board.insert(board.getCell(moveParser.getRow(), moveParser.getColumn()), moveParser.getSymbol());
                WinnerChecker.setBoard(board);
                currentPlayer = (currentPlayer == Player.CHAOS) ? Player.ORDER : Player.CHAOS;
            } catch (IllegalSymbolException | BoardIndexOutOfBoundsException |
                    TakenCellException | WrongNumberOfArgumentsException e) {
                ConsoleDrawer.println(e.getMessage() + " " + GameMessages.TRY_AGAIN + "\n");
            }
        } while (WinnerChecker.getWinnerRole() == null);

        ConsoleDrawer.println(board);

        if(WinnerChecker.getWinnerRole()==Player.CHAOS){
                ConsoleDrawer.println(GameMessages.CHAOS_WINS);
        } else{
                ConsoleDrawer.println(GameMessages.ORDER_WINS);
        }

    }


}
