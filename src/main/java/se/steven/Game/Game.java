package se.steven.Game;
import java.util.Scanner;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;

// Implement logic for constant methods

public class Game {

    // Constants
   private final static String KITCHEN = "Kitchen";
   private final static String BEDROOM = "Bedroom";
   private final static String HALL = "Hall";
   private final static String OFFICE = "Office";
   private final static String LIVINGROOM = "Living Room";
   private static final String GAME_START = "Start";
   private static String currentLocation = GAME_START;
   private boolean running = true;

    Scanner sc = new Scanner(System.in);

    Resident resident = new Resident("Resident", 10, 5);
    Burglar burglar = new Burglar("Burglar", 10, 7);

    public void gameStart() {

    while (running) {
    System.out.println("You can go to the Kitchen, Bedroom, Hall, Office or Living Room");
    currentLocation = LIVINGROOM;
    String choice = sc.nextLine();

    switch (choice) {
        case "Kitchen" -> Kitchen();
        case "Bedroom" -> Bedroom();
        case "Hall" -> Hall();
        case "Office" -> Office();
        case "Living Room" -> LivingRoom();
        case "Quit" -> running = false;

         }
        }
    }

    void Kitchen() {
        System.out.println("You enter the " + KITCHEN + " and see a frying pan on the table.");
        System.out.println("You may use the frying pan to knockout the attacker");
        System.out.println("What is your choice?");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Take")) {
            System.out.println("You pick up the frying pan");
            resident.setDamage(resident.getDamage() + 3);
        } else {
            System.out.println("You go back to the living room. ");
            currentLocation = LIVINGROOM;
        }
    }

    void Bedroom() {
        if (currentLocation.equals(LIVINGROOM)) {
            System.out.println("You have entered the " + BEDROOM);
            currentLocation = BEDROOM;
        }   else {
            System.out.println("You cannot go that way.");
        }
    }
    void Hall() {

        System.out.println("You have entered the " + HALL);
        currentLocation = HALL;
    }

    void Office() {
        System.out.println("You have entered the " + OFFICE);
        currentLocation = OFFICE;
    }

    void LivingRoom() {
        System.out.println("You have entered the " + LIVINGROOM);
        currentLocation = LIVINGROOM;
    }



}