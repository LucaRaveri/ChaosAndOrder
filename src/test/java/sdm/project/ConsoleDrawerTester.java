package sdm.project;


import org.junit.jupiter.api.Test;
import sdm.project.consolecomponents.ConsoleDrawer;
import sdm.project.core.entities.Board;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleDrawerTester {

    Board board = new Board();
    ByteArrayOutputStream fakeOutputStream = new ByteArrayOutputStream();

    @Test
    void boardDrawTest() throws IOException {
        System.setOut(new PrintStream(fakeOutputStream));
        ConsoleDrawer.println(board);

        assertEquals(Files.readString(Path.of("src/test/resources/EmptyBoardTemplate.txt")), fakeOutputStream.toString());
    }
}