package se.steven.Game;


public class Print {


    /* ----------------------------------------- */
    /* -----------------GENERAL------------------ */

    public void chooseDirection() {
        System.out.println("You may explore the kitchen, bedroom, hall, office or stay in the living room.");
    }


    public void wrongWay() {
        System.out.println("You cannot go that way");
    }

   public void alreadyInLivingRoom() {
        System.out.println("You're already in the living room, silly.");
   }



    /* ----------------------------------------- */
    /* -----------------BEDROOM------------------ */

    public void bedroomEntry() throws InterruptedException {
        System.out.println("After entering the bedroom, you notice that the burglar has gone through your belongings.");
        Thread.sleep(1300);
        System.out.println("It is not likely you will find anything of value, however you may choose to explore the room regardless.");
        Thread.sleep(1300);
        System.out.println("Would you like to explore or return to the living room?");
    }


    public void exploreBedroom() throws InterruptedException {
        System.out.println("Unfortunately, after exploring for a while, you find nothing to help you.");
        Thread.sleep(1400);
        System.out.println("You have now returned to the living room.");
    }

    public void exitBedroom() {
        System.out.println("You leave the bedroom and return to the living room.");
    }

    /* ----------------------------------------- */
    /* -----------------KITCHEN------------------ */


    public void fryingPanFound() throws InterruptedException {
        System.out.println("As you step into the doorway, you realize that you already explored this room and found a weapon.");
        Thread.sleep(1000);
        System.out.println("With this in mind, you return to the living room.");
    }


    public void firstEntry() throws InterruptedException {
        System.out.println("Entering the kitchen, you notice that there is a frying pan on the table.");
        Thread.sleep(1000);
        System.out.println("That could be a great weapon to defend yourself with. Would you like to take it or exit the room?");
    }


    public void acceptPan() {
        System.out.println("You pick up the frying pan and feel more secure. You exit to the living room.");
    }

    public void refusePan() {
        System.out.println("You decide not to take the pan and exit back to the living room.");
    }


    /* ----------------------------------------- */
    /* -----------------HALL-------------------- */

    public void hallEntry() {
        System.out.println("You enter the hall and spot the burglar!");
    }


    public void hallChoice() {
        System.out.println("Do you want to fight the burglar or flee for now?");
    }


    public void hallExit() {
        System.out.println("You sneak away hoping the burglar did not notice you, and return to the living room.");
    }

    /* ----------------------------------------- */
    /* -----------------OFFICE-------------------- */

    public void burglarConscious() {
        System.out.println("You may not enter the office as the burglar is blocking the way!");
    }


    public void victoryChoice() {
        System.out.println("With the burglar defeated, you may choose to call the police or continue to explore.");
    }


    /* ----------------------------------------- */
    /* -----------------INTRODUCTION-------------------- */

    public void introduce() throws InterruptedException {
        System.out.println("Welcome to the game.");
        Thread.sleep(1400);
        System.out.println("You are a resident who decided to nap in the living room after a long day at work.");
        Thread.sleep(1400);
        System.out.println("However, you wake up to find a burglar has invaded your home, luckily for you, he hasn't found you yet.");
        Thread.sleep(1400);
        System.out.println("Make sure to read through each interaction, as this will determine the outcome of the game.");
        Thread.sleep(1400);
        System.out.println("In order to win, you must find a weapon and knock out the burglar.");
        Thread.sleep(1400);
        System.out.println("Once you have done so, you must call the police from the office. Then, you will have won the game.");
        Thread.sleep(1400);
        System.out.println("Good luck.");
    }


}