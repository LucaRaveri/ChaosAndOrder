package sdm.project;

import org.junit.jupiter.params.provider.CsvSource;
import sdm.project.core.entities.Symbol;
import sdm.project.consolecomponents.MoveParser;
import sdm.project.core.exceptions.BoardIndexOutOfBoundsException;
import sdm.project.core.exceptions.IllegalSymbolException;
import sdm.project.core.exceptions.WrongNumberOfArgumentsException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveParserTester {

    private MoveParser moveParser = new MoveParser();


    @ParameterizedTest
    @CsvSource({"0, 0, CROSS,   a1 x  ", "4, 1, CIRCLE,   B5 o", "1, 3, CROSS,   d2 X"})
    public void testGetRow(int row, int column, Symbol symbol, String moveLine) throws WrongNumberOfArgumentsException, BoardIndexOutOfBoundsException, IllegalSymbolException {
        moveParser.setMoveLine(moveLine);
        assertEquals(row,moveParser.getRow());
        assertEquals(column,moveParser.getColumn());
        assertEquals(symbol,moveParser.getSymbol());
    }


    @ParameterizedTest
    @ValueSource(strings = {"r3 o", "k3 o", "q1 x", "p2 x",    //row exception case
                            "e0 o", "b7 o", "f54 o", "c54 x",  //column exception case
                            "r0 o", "p7 o", "k62 o"})          //both exception case
    public void testBoardIndexOutOfBoundsException(String command) {
        assertThrows(BoardIndexOutOfBoundsException.class, () -> moveParser.setMoveLine(command));
    }


    @ParameterizedTest
    @ValueSource(strings = {"c3 c", "b3 ze", "a5 p", "a2 i", "c2 oo"}) //wrong symbol
    public void testIllegalSymbolException(String command) {
        assertThrows(IllegalSymbolException.class, () -> moveParser.setMoveLine(command));
    }

    @ParameterizedTest
    @ValueSource(strings = {"c3  ", "b4 3 circle", "4 5 7 circle", "a", ""})  //wrong number of parameters
    public void testWrongNumberOfArgumentsException(String command) {
        assertThrows(WrongNumberOfArgumentsException.class, () -> moveParser.setMoveLine(command));
    }

}
