package gamelogic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import players.Human;
import players.RobotPlayer;
import tileanddeck.Deck;
import tileanddeck.Tile;

public class Game {
    private Deck deck; // has 28 tiles
    private Deque<Tile> deque = new ArrayDeque<>(); // the playground

    public List<Tile> getDeckAsList() {
        return this.getDeck().getDeck();
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Deque<Tile> getDeque() {
        return this.deque;
    }

    public Game() {
        this.deck = new Deck();
    }

    public void visualizePlayground() {
        Iterator<Tile> it = deque.iterator();
        while (it.hasNext()) {
            Tile temp = (Tile) it.next();
            System.out.printf("|%d|%d| ", temp.getLeft(), temp.getRight());
        }
        System.out.println();
    }

    public boolean playRound(Human humanPlayer, RobotPlayer robotPlayer) {
        State robotState = robotPlayer.playTurn(this, this.deque);
        if (robotState == State.NOVALIDTILES && robotPlayer.getNumberOfCardsInHand() != 0) {
            System.out.println("Your oponent doesn't have a valid tile to play, you win!");
            return false;
        }
        if (robotState == State.NOVALIDTILES && robotPlayer.getNumberOfCardsInHand() == 0) {
            System.out.println("Your opponent wins!");
            return false;
        }
        State humanState;
        do {
            humanState = humanPlayer.playTurn(this, this.deque);
        } while (humanState == State.WRONGINPUT);

        if (humanState == State.NOVALIDTILES && humanPlayer.getNumberOfCardsInHand() != 0) {
            System.out.println("You have no option to play, your opponent wins!");
            return false;
        } else if (humanState == State.NOVALIDTILES && humanPlayer.getNumberOfCardsInHand() == 0) {
            System.out.println("You win!");
            return false;
        }
        return true;
    }

    public void playGame(Human humanPlayer, RobotPlayer robotPlayer) {
        Random random = new Random();
        deque.push(this.getDeck().getDeck().remove(random.nextInt(28))); // first tile on the playground

        humanPlayer.dealTiles(this);
        robotPlayer.dealTiles(this);

        State firstInteraction = humanPlayer.playTurn(this, this.deque);
        boolean flag = false;
        if (firstInteraction == State.VALIDTILE) {
            flag = true;
        }
        while (flag == true) {
            flag = playRound(humanPlayer, robotPlayer);
        }
        System.out.println("End of the game!");
    }
}
