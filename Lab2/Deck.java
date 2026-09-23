package cardutils;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private final ArrayList<Card> theCards;
    private static final ArrayList<Card>protoDeck = new ArrayList<>();

    static {
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                protoDeck.add(new Card(rank,suit));
            }
        }
    }

    public Deck() {
        theCards = new ArrayList<>();
        fill();
    }

    public void fill() {
        theCards.clear();
        theCards.addAll(protoDeck);
    }


    public int getSize() {
        return theCards.size();
    }

    public Card dealCard() {
        return theCards.remove(theCards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(theCards);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "theCards=" + theCards +
                '}';
    }
}