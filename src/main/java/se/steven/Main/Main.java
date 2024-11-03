package se.steven.Main;
import se.steven.Game.Game;
import se.steven.Models.Resident;
import se.steven.Models.Burglar;
import se.steven.Models.Entity;


public class Main {
    public static void main(String[] args) {


    Game game = new Game();
    Resident resident = new Resident("Resident", 10, 6);
    Burglar burglar = new Burglar("Burglar", 10, 3);

        game.LivingRoom();
        game.gameStart();
    }
}