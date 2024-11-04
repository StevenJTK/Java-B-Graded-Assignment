package se.steven.Game;
import se.steven.Models.Entity;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import java.util.Scanner;

public class Fight {

    Fight fight = new Fight();
    Scanner sc = new Scanner(System.in);

    public static void battleLogic(Burglar attacker, Resident defender) {

            attacker.punch(defender);
            System.out.println("The burglar takes a swing at you for " + attacker.getDamage() + " damage");
            System.out.println("You now have " + defender.getHealth() + " health left.");

            defender.punch(attacker);
            System.out.println("You retaliate and hit the burglar for " + defender.getDamage() + " damage");
            System.out.println("The attacker now has " + attacker.getHealth() + " health left.");

            if (attacker.isConcious()) {
                System.out.println("The burglar is still conscious and swings a right hook. ");
                attacker.punch(defender);
            } else {
                System.out.println("You have knocked out the burglar and can now proceed to the office! ");

            }
        }
    }

