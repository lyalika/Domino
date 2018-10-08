package players;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import gamelogic.Game;
import tileanddeck.Tile;

public class RobotPlayerTest {
    @Test
    public void givenHandWithPlayableTileWhenChooseTileIsInvokedThenReturnPlayableTile() {
        Game game = new Game();
        Tile firstTile = new Tile(2, 3);
        RobotPlayer instance = new RobotPlayer();
        List<Tile> hand = new ArrayList<>();
        Tile expected = new Tile(3, 4);
        hand.add(expected);
        instance.setHand(hand);
        Tile result = instance.chooseTile(game, firstTile, firstTile);
        assertEquals(result, expected);
    }

    @Test
    public void givenHandWithNoTilesWhenChooseTileIsInvokedThenReturnNull() {
        Game game = new Game();
        RobotPlayer instance = new RobotPlayer();
        List<Tile> hand = new ArrayList<>();
        Tile firstTile = new Tile(2, 3);
        instance.setHand(hand);
        Tile result = instance.chooseTile(game, firstTile, firstTile);
        assertEquals(result, null);

    }

    @Test
    public void givenHandWithNoPlayableTilesWhenChooseTileIsInvokedThenReturnNull() {
        Game game = new Game();
        Tile firstTile = new Tile(2, 3);
        RobotPlayer instance = new RobotPlayer();
        List<Tile> hand = new ArrayList<>();
        Tile expected = new Tile(5, 4);
        hand.add(expected);
        instance.setHand(hand);
        Tile result = instance.chooseTile(game, firstTile, firstTile);
        assertEquals(result, null);
    }

    @Test
    public void givenInvalidNumberGetTileWithNumberIsInvokedThenReturnNull() {
        Player instance = new RobotPlayer();
        Tile result = instance.getTileWithNumber(7);
        assertEquals(result, null);
    }
}
