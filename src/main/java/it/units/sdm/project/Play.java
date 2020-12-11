package it.units.sdm.project;

import it.units.sdm.project.drawer.BoardDrawer;

public class Play {

    public static void main(String[] args) {

        Board board = new Board();

        //while (true/*fintanto che la partita non è finita*/) {
            //play move
            //stampa board


           // BoardDrawer.print(board);
        //}


    }

    private boolean isFinished(Board board){

        return board.isFull() || board.existsTris(); //sistema


    }

}
