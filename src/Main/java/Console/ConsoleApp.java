package Console;

import BestTower.BestTower;

import java.util.Locale;
import java.util.Scanner;

/**
 * This class handles the console application logic.
 * The main loop keeps running until the user decides to turn it off.
 */
public class ConsoleApp {

    boolean running = true;
    BestTower bestTower;
    Scanner myObj;

    public ConsoleApp() {
        myObj = new Scanner(System.in);
        bestTower = new BestTower();
    }

    public void start() {
        System.out.println("Welcome to the best tower analyser.");

        while(running) {
            System.out.println("[R]un the function");
            System.out.println("[Q]uit");
            var input = getInput("Enter command: ");
            input = input.toLowerCase(Locale.ROOT);

            switch (input) {
                case "r" -> {
                    Run();
                }
                case "q" -> {
                    Quit();
                }
                default -> {
                    System.out.println("Unknown command, ");
                }
            }
        }
    }

    private String getInput(String prompt) {
        System.out.println(prompt);
        return myObj.nextLine();
    }

    /**
     * Quit command logic
     */
    private void Quit() {
        var confirm = getInput("Do you want to exit? [Y/n]");
        confirm = confirm.toLowerCase(Locale.ROOT); // for easier use of switch later
        switch (confirm) {
            case "y": {
                running = false;
            }
            case "n": {
                break;
            }
            default: {
                System.out.println("Unknown command, back to main program");
            }
        }
    }

    /**
     * Run command logic
     */
    private void Run() {
        var farmId = getInput("Enter farm id: ");
        var towerId = bestTower.getBestTower(farmId);
        System.out.println("The tower with the lowest RSSI is id: \"" + towerId + "\".");
    }
}
