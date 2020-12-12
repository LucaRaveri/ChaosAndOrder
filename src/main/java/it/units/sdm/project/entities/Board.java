package it.units.sdm.project.entities;

public class Board {

    private final int SIZE = 6;
    private final Cell[][] board;

    public Board() {
        board = new Cell[SIZE][SIZE];
        build();
    }

    public int getSize(){
        return SIZE;
    }

    public Cell getCell(int row, int column) {
        return board[row][column];
    }

    public void addSymbol(int x, int y, Symbol symbol) {
        //TODO: check if the move is valid
        board[x-1][y-1].setSymbol(symbol);
    }

    public boolean isFull() {

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (board[row][column] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private void build() {
        for(int row=0; row<SIZE; row++){
            for(int column=0; column<SIZE; column++){
                board[row][column]=new Cell();
            }
        }
    }
}
