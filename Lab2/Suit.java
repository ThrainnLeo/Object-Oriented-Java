package cardutils;

public enum Suit {
    SPADES("♠️"),
    HEARTS("♥️"),
    DIAMONDS("♦️"),
    CLUBS("♣️");

    private final String symbol;

    private Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}