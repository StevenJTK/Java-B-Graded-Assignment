package se.steven.Game;
import se.steven.Models.Entity;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import java.util.Scanner;
import static se.steven.Game.Game.LivingRoom;

public class Fight {

    private static boolean running = true;
    Fight fight = new Fight();
    static Scanner sc = new Scanner(System.in);

    public static void battleLogic(Burglar attacker, Resident defender) {

        while (running && attacker.isConcious() && defender.isConcious()) {
            attacker.punch(defender);
            System.out.println("The burglar catches you by surprise and sucker punches you for  " + attacker.getDamage() + " damage");
            System.out.println("You now have " + defender.getHealth() + " health left.");

            if(!defender.isConcious()) {
                System.out.println("You are no longer able to fight.");
                running = false;
            }

            defender.punch(attacker);
            System.out.println("You hit back for  " + defender.getDamage() + " damage");
            System.out.println("The thief now has " + attacker.getHealth() + " health left.");

            if (!attacker.isConcious()) {
                System.out.println(attacker.getRole() + " has been knocked out!");
                System.out.println("You have knocked out the burglar and may now proceed to the office!");
            }

            }
        }
    }