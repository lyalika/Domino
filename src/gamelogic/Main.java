package gamelogic;

import players.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Human humanPlayer = new Human();
        RobotPlayer robotPlayer = new RobotPlayer();
        game.playGame(humanPlayer, robotPlayer);
    }
}
