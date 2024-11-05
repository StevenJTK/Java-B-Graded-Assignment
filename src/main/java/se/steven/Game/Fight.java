package se.steven.Game;
import se.steven.Models.Entity;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import java.util.Scanner;


public class Fight extends Game {


    private static boolean running = true;

    Fight fight = new Fight();
    static Scanner sc = new Scanner(System.in);

    public static void battleLogic(Burglar attacker, Resident defender) {

        while (running && attacker.isConcious() && defender.isConcious()) {

            attacker.punch(defender);
            System.out.println("The burglar catches you by surprise and sucker punches you for " + attacker.getDamage() + " damage.");
            System.out.println("You now have " + defender.getHealth() + " health left.");

            if (!defender.isConcious()) {
                System.out.println("The burglar knocks you unconscious and continues to ransack your home.");
                System.out.println("GAME OVER! ");
                running = false;
                break;
            }


            defender.punch(attacker);
            System.out.println("You hit back for " + defender.getDamage() + " damage.");
            System.out.println("The thief now has " + attacker.getHealth() + " health left.");

            if (!attacker.isConcious()) {
                System.out.println("You have successfully knocked out the thief! ");
                System.out.println("Continue to the Office in order to call the police and finish the game. ");
                exploreHall();
                running = false;
                break;
            }
        }
    }
}