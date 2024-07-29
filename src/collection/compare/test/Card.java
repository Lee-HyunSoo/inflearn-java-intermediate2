package collection.compare.test;

public class Card implements Comparable<Card> {

    private final int rank; // 숫자
    private final Suit suit; // 문양

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        if (this.rank == o.rank) {
            return this.suit.compareTo(o.suit);
        }
        return this.rank - o.rank;
    }

    @Override
    public String toString() {
        return rank + "(" + suit.getIcon() + ")";
    }
}
