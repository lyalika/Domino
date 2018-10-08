package players;

import java.util.Deque;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import gamelogic.Game;
import tileanddeck.Tile;
import gamelogic.State;

public class Human extends Player {
    private final int cardsInHand = 7;

    @Override
    public Tile chooseTile(Game game, Tile leftSide, Tile rightSide) {
        Iterator<Tile> iterator = this.hand.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Tile temp = (Tile) iterator.next();
            System.out.printf("Tile %d: |%d|%d|", i, temp.getLeft(), temp.getRight());
            i++;
            System.out.println();
        }
        System.out.println("Option 7: there are no valid options");
        System.out.println();
        game.visualizePlayground();
        System.out.printf("Valid numbers to put at the two sides are %d and %d", leftSide.getLeft(),
                rightSide.getRight());
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int response;
        do {
            System.out.println("Enter the number of the tile you want to play!");
            response = scanner.nextInt();
        } while (response < 0 || response > 7 || (response >= this.getNumberOfCardsInHand() && response != 7));

        if (response == 7) {
            return null;
        }
        return this.hand.get(response);

    }

    @Override
    public State playTurn(Game game, Deque<Tile> deque) {
        Tile tile = chooseTile(game, deque.peekFirst(), deque.peekLast());
        if (tile == null) {
            return State.NOVALIDTILES;
        }
        if (tile != null && tile.getLeft() != game.getDeque().getFirst().getLeft()
                && tile.getRight() != game.getDeque().getFirst().getLeft()
                && tile.getLeft() != game.getDeque().getLast().getRight()
                && tile.getRight() != game.getDeque().getLast().getRight()) {
            return State.WRONGINPUT;
        }
        if (tile != null) {
            hand.remove(tile);
            findPlace(tile, deque);
            return State.VALIDTILE;
        }
        return State.WRONGINPUT;
    }

    @Override
    public void dealTiles(Game game) {
        Random random = new Random();
        for (int i = 0; i < cardsInHand; i++) {
            int size = game.getDeckAsList().size() - 1;
            this.hand.add(game.getDeckAsList().remove(random.nextInt(size)));
        }

    }
}
