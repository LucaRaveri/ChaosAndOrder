package it.units.sdm.project;

public class Board {

    Boolean[][] board = new Boolean[6][6];

    public Board(){

    }

    Boolean getCell(int i, int j){
        return board[i][j];
    }

}
