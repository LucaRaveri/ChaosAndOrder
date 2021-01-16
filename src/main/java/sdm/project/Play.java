package sdm.project;

import javafx.application.Application;
import sdm.project.consolecomponents.ConsoleDrawer;
import sdm.project.core.utils.GameMessages;

import java.util.Scanner;

public class Play {

    public static final String SYNTAX_INSTRUCTIONS = "Expected parameter -cli or -gui!";

    public static void main(String[] args) {

//        if (args.length != 1 || !args[0].matches("(-cli)|(-gui)")) {
//            System.out.println(SYNTAX_INSTRUCTIONS);
//            System.exit(0);
//        }
//
//        if (args[0].equals("-cli")) {
//            startConsoleGame();
//        } else {
            Application.launch(GUIGame.class);
//        }

    }

    public static void startConsoleGame() {

        Scanner scanner = new Scanner(System.in);

        ConsoleDrawer.print(GameMessages.LOGO);
        ConsoleDrawer.println(GameMessages.WELCOME);
        ConsoleDrawer.print(GameMessages.INTRO);

        do {
            ConsoleGame game = new ConsoleGame();
            game.start();
            ConsoleDrawer.print("Do you want to play again? [yes/no] ");
        } while (scanner.nextLine().trim().equals("yes"));

        ConsoleDrawer.println("See you next time!");
    }


}
