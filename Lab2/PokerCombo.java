package Ps;

public enum PokerCombo {
    NONE(0),
    PAIR(1),
    TWO_PAIR(3),
    THREE_OF_A_KIND(6),
    FOUR_OF_A_KIND(16),
    FULL_HOUSE(10),
    FLUSH(5);

    private final int point;

    PokerCombo(int point) {
        this.point = point;
    }

    public int getCombos() {
        return point;
    }
}
