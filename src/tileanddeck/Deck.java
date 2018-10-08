package tileanddeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Tile> deck = new ArrayList<>();

    public Deck() {
        init();
    }

    public List<Tile> getDeck() {
        return this.deck;
    }

    public void init() {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                Tile temp = new Tile(i, j);
                deck.add(temp);
            }
        }
    }
}
