package it.units.sdm.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTestClass {

    @Test
    void firstTest(){
        Board board = new Board();
        assertEquals(null, board.getCell(0, 0));
    }

}
