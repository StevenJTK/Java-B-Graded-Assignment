package se.steven.Main;

import se.steven.Game.Game;
import se.steven.Game.Introduction;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Game game = new Game();
        Introduction introduce = new Introduction();

        Introduction.introduce();
        game.LivingRoom();
        game.gameStart();


    }
}