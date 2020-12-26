package it.units.sdm.project;

import it.units.sdm.project.console.ConsoleGame;
import it.units.sdm.project.utils.ConsoleDrawer;
import it.units.sdm.project.utils.GameMessages;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsoleDrawer.print(GameMessages.LOGO);
        ConsoleDrawer.println(GameMessages.WELCOME);
        ConsoleDrawer.print(GameMessages.INTRO);

        do {
            ConsoleGame game = new ConsoleGame();
            game.start();
            System.out.print("Do you want to play again? [yes/no] ");
        } while (scanner.nextLine().trim().equals("yes"));

    }

}
