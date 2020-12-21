package it.units.sdm.project.utils;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Cell;
import it.units.sdm.project.entities.Role;
import it.units.sdm.project.entities.Symbol;

import java.util.Arrays;
import java.util.stream.Stream;

public class WinnerChecker {

    // TODO: use Streams
    private static final int SIZE_TO_WIN = 5;
    public static boolean thereIsAWinner(Board board) {
        return chaosWinCondition(board) || orderWinCondition(board);
    }

    public static Role getWinnerRole(Board board) {
        if (thereIsAWinner(board)) {
            if (chaosWinCondition(board)) {
                return Role.CHAOS;
            } else {
                return Role.ORDER;
            }
        } else {
            return null;
        }

    }

    private static boolean chaosWinCondition(Board board) {
        return board.isFull();
    }

    private static boolean orderWinCondition(Board board) {
        return checkRows(board) || checkColumns(board) || checkPrimaryDiagonals(board) || checkSecondaryDiagonals(board);
    }

    private static boolean checkRows(Board board) {
        int count;
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j <= Board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(i, j).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    continue;
                }
                for (int k = 1; k < SIZE_TO_WIN; k++) {
                    if (board.getCell(i, j + k).getSymbol() == currentSymbol && board.getCell(i, j + k).getSymbol() != null ) {
                        count++;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

//    private static boolean checkRows(Board board) {
//        // TODO: refactor using streams
//    }

    private static boolean checkColumns(Board board) {
        int count;
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j <= Board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(j, i).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    continue;
                }
                for (int k = 1; k < SIZE_TO_WIN; k++) {
                    if (board.getCell(j + k, i).getSymbol() == currentSymbol) {
                        count++;
                    }
                    if (count >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkPrimaryDiagonals(Board board) {
        int count;
        for (int i = 0; i <= Board.SIZE - SIZE_TO_WIN; i++) {
            for (int j = 0; j <= Board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(i, j).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    continue;
                }
                for (int k = 1; k < SIZE_TO_WIN; k++) {
                    if (board.getCell(i + k, j + k).getSymbol() == currentSymbol) {
                        count++;
                    }
                    if (count >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkSecondaryDiagonals(Board board) {
        int count;
        for (int i = SIZE_TO_WIN - 1; i < Board.SIZE ; i++) {
            for (int j = 0; j <= Board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(i, j).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    continue;
                }
                for (int k = 1; k < SIZE_TO_WIN; k++) {
                    if (board.getCell(i - k, j + k).getSymbol() == currentSymbol) {
                        count++;
                    }
                    if (count >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}