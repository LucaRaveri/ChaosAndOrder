package it.units.sdm.project.entities;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.Symbol;

public class WinnerChecker {

    private Board board;
    private static final int SIZE_TO_WIN = 5;

    public void setCurrentBoard(Board board) {
        this.board = board;
    }

    public boolean thereIsAWinner() {
        return chaosWinCondition() || orderWinCondition();
    }

    public Player.Role getWinner() {
        if (thereIsAWinner()) {
            if (orderWinCondition()) {
                return Player.Role.ORDER;
            } else {
                return Player.Role.CHAOS;
            }
        } else {
            return null;
        }

    }

    private boolean chaosWinCondition() {
        return board.isFull();
    }

    private boolean orderWinCondition() {
        int count;
        // check righe
        for (int i = 0; i < board.SIZE; i++) {
            for (int j = 0; j <= board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(i, j).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    break;
                }
                for (int k = 1; k < SIZE_TO_WIN; k++) {
                    if (board.getCell(i, j + k).getSymbol() == currentSymbol) {
                        count++;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        // check colonne
        for (int i = 0; i < board.SIZE; i++) {
            for (int j = 0; j <= board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(j, i).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    break;
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
        // check diag 1
        for (int i = 0; i <= board.SIZE - SIZE_TO_WIN; i++) {
            for (int j = 0; j <= board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(i, j).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    break;
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
        // check diag 2
        for (int i = SIZE_TO_WIN - 1; i < board.SIZE - 1; i++) {
            for (int j = 0; j <= board.SIZE - SIZE_TO_WIN; j++) {
                Symbol currentSymbol = board.getCell(i, j).getSymbol();
                count = 0;
                if (currentSymbol == null) {
                    break;
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
