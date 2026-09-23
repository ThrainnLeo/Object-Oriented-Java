package cardutils;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRankValue() {
        return rank.getValue();
    } //Detta skulle vara bra för stege

    public int getSuitValue() { //Man kan ske vill göra detta till en random generator för att slumpa
        return suit.ordinal();
    } //Detta skulle vara bra för straight flush

    public boolean equals(Card otherCard) {
        return this.rank == otherCard.rank && this.suit == otherCard.suit;
    }

    public String toShortString() {
        return rank.getSymbol() + suit.getSymbol();
    }

    @Override
    public String toString() {
        String info = rank + " of " + suit;
        return info;
    }

}