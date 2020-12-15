package it.units.sdm.project;

import it.units.sdm.project.utils.MoveParser;
import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;
import it.units.sdm.project.exceptions.WrongNumberOfArgumentsException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTester {

    @ParameterizedTest
    @ValueSource(strings = {"r3 o", "k3 o", "q1 x", "p2 x",    //row exception case
                            "e0 o", "b7 o", "f54 o", "c54 x",  //column exception case
                            "r0 o", "p7 o", "k62 o"})               //both exception case
    void testBoardIndexOutOfBoundsException(String command) {
        BoardIndexOutOfBoundsException thrown = assertThrows(
                BoardIndexOutOfBoundsException.class,
                () -> MoveParser.setMoveLine(command));
    }


    @ParameterizedTest
    @ValueSource(strings = {"c3 c", "b3 ze", "a5 p", "a2 i", "c2 oo"}) //wrong symbol
    void testIllegalSymbolException(String command) {
        IllegalSymbolException thrown = assertThrows(
                IllegalSymbolException.class,
                () -> MoveParser.setMoveLine(command));
    }

    @ParameterizedTest
    @ValueSource(strings = {"c3  ", "b4 3 circle", "4 5 7 circle", "a", ""})  //wrong number of parameters
    void testWrongNumberOfArgumentsException(String command) {
        WrongNumberOfArgumentsException thrown = assertThrows(
                WrongNumberOfArgumentsException.class,
                () -> MoveParser.setMoveLine(command));
    }

}
