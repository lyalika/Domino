package gamelogic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tileanddeck.Tile;

public class GameTest {
    @Test
    public void givenTileWhenReverseIsInvokedThenReturnReversed() {
        Game instance = new Game();
        Tile toBeReversed = new Tile(2, 3);
        instance.reverse(toBeReversed);
        assertEquals(toBeReversed.getLeft(), 3);
        assertEquals(toBeReversed.getRight(), 2);
    }

    @Test
    public void givenValidTileWithRightOrientationWhenFindPlaceIsInvokedThenPutTileOnTheLeft() {
        Game instance = new Game();
        Tile toBePlaced = new Tile(2, 3);
        instance.getDeque().add(new Tile(3, 4));
        instance.findPlace(toBePlaced);
        assertEquals(instance.getDeque().size(), 2);
        assertEquals(instance.getDeque().getFirst().getLeft(), 2);
    }

    @Test
    public void givenValidTileWithReverseOrientationWhenFindPlaceIsInvokedThenPutTileOnTheLeftReversed() {
        Game instance = new Game();
        Tile toBePlaced = new Tile(3, 2);
        instance.getDeque().add(new Tile(3, 4));
        instance.findPlace(toBePlaced);
        assertEquals(instance.getDeque().size(), 2);
        assertEquals(instance.getDeque().getFirst().getLeft(), 2);
    }

    @Test
    public void givenValidTileWithRightOrientationWhenFindPlaceIsInvokedThenPutTileOnTheRight() {
        Game instance = new Game();
        Tile toBePlaced = new Tile(4, 5);
        instance.getDeque().add(new Tile(3, 4));
        instance.findPlace(toBePlaced);
        assertEquals(instance.getDeque().size(), 2);
        assertEquals(instance.getDeque().getLast().getRight(), 5);
    }

    @Test
    public void givenValidTileWithReversedOrientationWhenFindPlaceIsInvokedThenPutTileOnTheRightReversed() {
        Game instance = new Game();
        Tile toBePlaced = new Tile(5, 4);
        instance.getDeque().add(new Tile(3, 4));
        instance.findPlace(toBePlaced);
        assertEquals(instance.getDeque().size(), 2);
        assertEquals(instance.getDeque().getLast().getRight(), 5);
    }
}
