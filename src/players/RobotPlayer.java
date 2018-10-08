package players;

import java.util.Deque;
import java.util.Random;

import gamelogic.*;
import tileanddeck.Tile;

public class RobotPlayer extends Player {
    @Override
    public Tile chooseTile(Game game, Tile leftSide, Tile rightSide) {
        Tile tileForLeftSide = getTileWithNumber(leftSide.getLeft());
        Tile tileForRightSide = getTileWithNumber(rightSide.getRight());

        if (tileForLeftSide != null) {
            return tileForLeftSide;
        } else if (tileForRightSide != null) {
            return tileForRightSide;
        } else {
            return null;
        }
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

        for (int i = 0; i < 7; i++) {
            int size = game.getDeckAsList().size() - 1;
            this.hand.add(game.getDeckAsList().remove(random.nextInt(size)));
        }

    }
}
