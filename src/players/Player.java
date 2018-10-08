package players;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import gamelogic.*;
import tileanddeck.Tile;

public abstract class Player {
    protected List<Tile> hand = new ArrayList<>();

    public void setHand(List<Tile> newHand) {
        this.hand = newHand;
    }

    public int getNumberOfCardsInHand() {
        return this.hand.size();
    }

    public abstract Tile chooseTile(gamelogic.Game game, Tile leftSide, Tile rightSide);

    public abstract State playTurn(Game game, Deque<Tile> deque);

    public abstract void dealTiles(Game game);

    public Tile getTileWithNumber(int number) {
        for (Tile tile : this.hand) {
            if (tile.getRight() == number || tile.getLeft() == number) {
                return tile;
            }
        }
        return null;
    }

    public void reverse(Tile toBeReversed) {
        int temp = toBeReversed.getLeft();
        toBeReversed.setLeft(toBeReversed.getRight());
        toBeReversed.setRight(temp);
    }

    public void findPlace(Tile toBePlaced, Deque<Tile> deque) {
        if (deque.peekFirst().getLeft() == toBePlaced.getRight()) {
            deque.addFirst(toBePlaced);
        } else if (deque.peekFirst().getLeft() == toBePlaced.getLeft()) {
            reverse(toBePlaced);
            deque.addFirst(toBePlaced);
        } else if (deque.peekLast().getRight() == toBePlaced.getLeft()) {
            deque.addLast(toBePlaced);
        } else {
            reverse(toBePlaced);
            deque.addLast(toBePlaced);
        }
    }

}
