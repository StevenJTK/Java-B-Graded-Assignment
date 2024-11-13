package se.steven.Game;
import java.util.Scanner;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import static se.steven.Game.Fight.battleLogic;

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

    // Constructors
    Resident resident = new Resident("resident", 10, 3);
    static Burglar burglar = new Burglar("burglar", 10, 4);
    static Print print = new Print();


    public void gameStart() throws InterruptedException {
        while (running) {
            print.chooseDirection();
            String choice = sc.nextLine();

            switch (choice) {
                case "Kitchen", "kitchen" -> Kitchen();
                case "Bedroom", "bedroom" -> Bedroom();
                case "Hall", "hall" -> Hall();
                case "Office", "office" -> Office(burglar);
                case "Living Room", "living room" -> LivingRoom();
                case "Quit", "quit" -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void LivingRoom() {
        if (!currentLocation.equals(LIVING_ROOM)) {
            currentLocation = LIVING_ROOM;
        } else {
            print.alreadyInLivingRoom();
        }
    }

    private void Bedroom() throws InterruptedException {
        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = BEDROOM;
            print.bedroomEntry();
            String localChoice = sc.nextLine();
            switch (localChoice) {
                case "Explore", "explore" -> {
                    print.exploreBedroom();
                    currentLocation = LIVING_ROOM;
                }
                case "Return", "return" -> {
                    print.exitBedroom();
                    currentLocation = LIVING_ROOM;
                }
            }
        } else {
            print.wrongWay();
        }
    }

    private void Kitchen() throws InterruptedException {

        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = KITCHEN;

            if (fryingPanFound) {
                print.fryingPanFound();
                currentLocation = LIVING_ROOM;
                return;
            }
            print.firstEntry();
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Take")) {
                fryingPanFound = true;
                print.acceptPan();
                resident.setDamage(resident.getDamage() + 3);
                currentLocation = LIVING_ROOM;
            } else {
                print.refusePan();
                currentLocation = LIVING_ROOM;
            }
        } else {
            print.wrongWay();
        }
    }

    private void Hall() throws InterruptedException {
        if (currentLocation.equals(LIVING_ROOM)) {
            print.hallEntry();
            currentLocation = HALL;
        } else {
            print.wrongWay();
        }

        print.hallChoice();
        String hallChoice = sc.nextLine();
        switch (hallChoice) {
            case "Fight", "fight" -> battleLogic(burglar, resident);
            case "Flee", "flee" -> {
                if(currentLocation.equals(HALL)) {
                    print.hallExit();
                    currentLocation = LIVING_ROOM;
                }
            }
            case "Quit", "quit" -> running = false;
            default -> System.out.println("Invalid choice");
        }
    }

    private void Office(Burglar attacker) throws InterruptedException {
        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = OFFICE;
        } else {
            print.wrongWay();
        }

        if (attacker.isConcious()) {
            print.burglarConscious();
            currentLocation = LIVING_ROOM;

        } else {
            print.victoryChoice();
            String officeChoice = sc.nextLine();
            switch (officeChoice) {
                case "Call", "call" -> {
                    System.out.println("You ring the police and get to safety.");
                    Thread.sleep(500);
                    System.out.println("You win!");
                    running = false;
                }
                case "Explore", "explore" -> {
                    System.out.println("You return to the living room to continue to explore.");
                    currentLocation = LIVING_ROOM;
                }

                case "Quit", "quit" -> running = false;
            }
        }

    }


    static void exploreHall() {
        currentLocation = LIVING_ROOM;
    }

    public static void gameOver() {
        running = false;
        System.out.println("The burglar has defeated you. GAME OVER!");
    }
}