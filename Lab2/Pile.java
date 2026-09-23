package cardutils;
import java.util.ArrayList;
import java.util.List;


    public class Pile {

        private ArrayList<Card> theCards;

        public Pile() {
            this.theCards = new ArrayList<>();
        }

        public Pile(ArrayList<Card> initialCards) {
            ArrayList<Card> copy = new ArrayList<>(initialCards);
            this.theCards = copy;
        }

        public int getSize() {
            return theCards.size();
        }

        public void clear() {
            theCards.clear();
        }

        public void add(Card c) {
            theCards.add(c);
        }

        public void add(List<Card> cards){
            theCards.addAll(cards);
        }

        public Card get(int index) {
            return theCards.get(index);
        }

        public List<Card> getCards() {
            return new ArrayList<>(theCards);
        }

        public Card remove(int index) {
            Card c = theCards.remove(index);
            return c;
        }

        public boolean remove(Card c) {
            return theCards.remove(c);
        }

        public boolean contains(Card c) {
            return theCards.contains(c);
        }

        public boolean remove(List<Card>  cards) {
            return theCards.removeAll(cards);
        }

        public int noOfSuit(Suit suit) {
            int count = 0;
            for (Card c : theCards) {
                if (c.getSuit() == suit) {
                    count++;
                }
            }
            return count;
        }

        public int noOfRank(Rank rank) {
            int count = 0;
            for (Card c : theCards) {
                if (c.getRank() == rank) {
                    count++;
                }
            }
            return count;
        }

    @Override
    public String toString() {
        return "Pile{" +
                "theCards=" + theCards +
                '}';
    }
}

