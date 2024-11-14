package se.steven.Game;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import static se.steven.Game.Game.*;


public class Fight {

    private static boolean running = true;

    public static void battleLogic(Burglar attacker, Resident defender) throws InterruptedException {

        while (running && attacker.isConcious() && defender.isConcious()) {

            attacker.punch(defender);
            System.out.println("The " + burglar.getRole() + " punches you for " + attacker.getDamage() + " damage.");
            System.out.println("You now have " + defender.getHealth() + " health left.");
            Thread.sleep(1500);

            if (!defender.isConcious()) {
                gameOver();

                running = false;
                break;
            }

            defender.punch(attacker);
            System.out.println("You hit the " + burglar.getRole() + " back for " + defender.getDamage() + " damage.");
            System.out.println("The " + burglar.getRole()  + " now has " + attacker.getHealth() + " health left.");

            if (!attacker.isConcious()) {
                System.out.println("You have successfully knocked out the " + burglar.getRole() + "!");
                Thread.sleep(1000);
                System.out.println("Continue to the office in order to call the police and finish the game. ");

                exploreHall();
                running = false;
                break;
            }
        }
    }


}