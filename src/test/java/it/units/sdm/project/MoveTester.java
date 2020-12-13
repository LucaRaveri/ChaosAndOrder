package it.units.sdm.project;

import it.units.sdm.project.entities.Move;
import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTester {



    @ParameterizedTest
    @ValueSource(strings = {"0 3 circle", "7 3 cross", "-1 1 cross", "102 2 cross",    //row exception case
                            "5 0 circle", "2 7 circle", "-4 1 circle", "3 54 circle",  //column exception case
                            "0 0 circle", "7 7 cross", "-27 62 circle"})               //both exception case
    void testBoardIndexOutOfBoundsException(String command) {
        BoardIndexOutOfBoundsException thrown = assertThrows(
                BoardIndexOutOfBoundsException.class,
                () -> new Move(command));
    }

}
