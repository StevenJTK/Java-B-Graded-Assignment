package se.steven.Game;
import java.util.Scanner;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import static se.steven.Models.Entity.startFight;

// Implement logic for constant methods

public class Game {

    // Constants
   private final static String KITCHEN = "Kitchen";
   private final static String BEDROOM = "Bedroom";
   private final static String HALL = "Hall";
   private final static String OFFICE = "Office";
   private final static String LIVINGROOM = "Living Room";
   private static String currentLocation = LIVINGROOM;
   private boolean running = true;

    Scanner sc = new Scanner(System.in);

    Resident resident = new Resident("Resident", 10, 5);
    Burglar burglar = new Burglar("Burglar", 10, 7);

    public void gameStart() {

    while (running) {
    System.out.println("You can go to the Kitchen, Bedroom, Hall, Office or Living Room");
    String choice = sc.nextLine();

    switch (choice) {
        case "Kitchen" -> Kitchen();
        case "Bedroom" -> Bedroom();
        case "Hall" -> startFight(burglar, resident);
        case "Office" -> Office();
        case "Living Room" -> LivingRoom();
        case "Quit" -> running = false;
            }
        }
    }

   public static void LivingRoom() {
        if(!currentLocation.equals(LIVINGROOM)) {
            currentLocation = LIVINGROOM;
        }   else {
            System.out.println("You cannot go that way yet. ");
        }
   }

    // Implement exploration but nothing of value comes out
    void Bedroom() {
        if(currentLocation.equals(LIVINGROOM)) {
            System.out.println("Entering Bedroom");
            currentLocation = BEDROOM;
        }   else {
            System.out.println("You cannot enter from this direction");
        }
    }
    // Implement logic for once the frying pan has been found
    void Kitchen() {
        System.out.println("You enter the " + KITCHEN + " and see a frying pan on the table.");
        System.out.println("You may use the frying pan to knockout the attacker");
        System.out.println("What is your choice? Input Take or Exit");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Take")) {
            System.out.println("You pick up the frying pan and exit the room.");
            resident.setDamage(resident.getDamage() + 3);
            currentLocation = LIVINGROOM;
        } else {
            System.out.println("You go back to the living room. ");
            currentLocation = LIVINGROOM;
        }
    }
    // Implement burglar & fight sequence
    void Hall() {
        if(currentLocation.equals(LIVINGROOM)) {
            System.out.println("Entering Hall");
            currentLocation = HALL;
        }   else {
            System.out.println("You cannot enter from this direction");
        }
    }
    // Test this
    void Office() {
        if(burglar.isConcious()) {
            System.out.println("You need to take out the burglar before entering the office. ");
            currentLocation = OFFICE;
            System.out.println("You return to the living room. ");
            currentLocation = LIVINGROOM;
        }   else {
            System.out.println("You have succesfully taken out the burglar and called the police, well done! ");
            running = false;
        }
    }

}