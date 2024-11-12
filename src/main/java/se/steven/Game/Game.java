package se.steven.Game;
import java.util.Scanner;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import static se.steven.Game.Fight.battleLogic;

// ADD CLOSE SCANNER!!
// Implement default in Enhanced Switch
// Polymorph Entity + Resident/Burglar?
// Experiment Entity + interface

public class Game {

    // Constants
    private final static String KITCHEN = "Kitchen";
    private final static String BEDROOM = "Bedroom";
    private final static String HALL = "Hall";
    private final static String OFFICE = "Office";
    private final static String LIVING_ROOM = "Living Room";
    private final static String GAME_START = "Game Start";
    private static String currentLocation = GAME_START;
    private static boolean running = true;
    private static boolean fryingPanFound = false;

    Scanner sc = new Scanner(System.in);

    Resident resident = new Resident("Resident", 10, 3);
    Burglar burglar = new Burglar("Burglar", 10, 4);


    public void gameStart() {

        while (running) {
            System.out.println("You can go to the Kitchen, Bedroom, Hall, Office or Living Room");
            String choice = sc.nextLine();

            if (running) {

            }

            switch (choice) {
                case "Kitchen" -> Kitchen();
                case "Bedroom" -> Bedroom();
                case "Hall" -> Hall();
                case "Office" -> Office(burglar);
                case "Living Room" -> LivingRoom();
                case "Quit" -> running = false;
            }
        }
    }

    public static void LivingRoom() {
        if (!currentLocation.equals(LIVING_ROOM)) {
            currentLocation = LIVING_ROOM;
        } else {
            System.out.println("You cannot go that way yet. ");
        }
    }

    // Implement equalsIgnoreCase
    private void Bedroom() {
        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = BEDROOM;
            System.out.println("You have entered the bedroom. It doesn't look like there is much to do here.");
            System.out.println("Would you like to explore the room or exit to the living room? ");
            String localChoice = sc.nextLine();
            switch (localChoice) {
                case "Explore" -> exploreBedroom();
                case "Exit" -> exitBedroom();
            }

        } else {
            System.out.println("You cannot enter from this direction");
        }
    }

    private void Kitchen() {

        if (currentLocation.equals(LIVING_ROOM)) {
            System.out.println("Entering Kitchen");
            currentLocation = KITCHEN;


            if (fryingPanFound) {
                System.out.println("You have already explored the kitchen and found the frying pan.");
                System.out.println("You return to the living room.");
                currentLocation = LIVING_ROOM;
                return;
            }

            System.out.println("You enter the " + KITCHEN + " and see a frying pan on the table.");
            System.out.println("You may use the frying pan to knock out the attacker.");
            System.out.println("What is your choice? Input 'Take' or 'Exit'");

            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Take")) {
                fryingPanFound = true;
                System.out.println("You pick up the frying pan and exit the room.");
                resident.setDamage(resident.getDamage() + 3);
                currentLocation = LIVING_ROOM;
            } else {
                System.out.println("You go back to the living room.");
                currentLocation = LIVING_ROOM;
            }
        } else {
            System.out.println("You cannot enter from this direction.");
        }
    }

    private void Hall() {
        if (currentLocation.equals(LIVING_ROOM)) {
            System.out.println("You enter the hall and see the burglar.");
            currentLocation = HALL;
        } else {
            System.out.println("You cannot enter from this direction");
        }

        System.out.println("You can choose to stand your ground and Fight or Flee. ");
        String hallChoice = sc.nextLine();
        switch (hallChoice) {
            case "Fight" -> battleLogic(burglar, resident);
            case "Flee" -> exitHall();
        }
    }

    private void Office(Burglar attacker) {
        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = OFFICE;
        } else {
            System.out.println("You cannot enter from this direction");
        }

        if (attacker.isConcious()) {
            System.out.println("You may not enter the office yet, the burglar is still alive!");
            currentLocation = LIVING_ROOM;

        } else {
            System.out.println("After defeating the burglar, you enter the office. Would you like to call the police or continue exploring? ");
            String officeChoice = sc.nextLine();
            switch (officeChoice) {
                case "Call" -> {
                    System.out.println("You ring the police and get to safety.");
                    running = false;
                }
                case "Explore" -> {
                    System.out.println("You return to the living room to continue to explore.");
                    currentLocation = LIVING_ROOM;
                }

            }
        }

    }


    private void exploreBedroom() {
        System.out.println("You explore the bedroom, however you find nothing of value.");
        if (currentLocation.equals(BEDROOM))
            System.out.println("You exit the bedroom and back to the living room. ");
        currentLocation = LIVING_ROOM;
    }

    private void exitBedroom() {
        System.out.println("You choose to exit the bedroom and return to the living room. ");
        currentLocation = LIVING_ROOM;
    }

    static void exploreHall() {

        currentLocation = LIVING_ROOM;
    }


    private void exitHall() {
        if (currentLocation.equals(HALL)) ;
        System.out.println("You sneak away from the hall and back to the living room. ");
        currentLocation = LIVING_ROOM;
    }


    public static void gameOver() {
        running = false;
        System.out.println("The burglar has defeated you. GAME OVER!");
    }



}