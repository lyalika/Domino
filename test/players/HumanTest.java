import static org.junit.Assert.*;

import org.junit.Test;

import players.*;
import tileanddeck.Tile;

public class HumanTest {

    @Test
    public void givenInvalidNumberGetTileWithNumberIsInvokedThenReturnNull() {
        Player instance = new Human();
        Tile result = instance.getTileWithNumber(7);
        assertEquals(result, null);
    }

}
