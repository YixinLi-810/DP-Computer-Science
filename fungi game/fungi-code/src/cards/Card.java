package cards;

public class Card {
    protected String cardName;

    public Card(String cardName) {
        this.cardName = cardName;
    }

    public String getName() {
        return cardName;
    }

    public String toString() {
        return cardName;
    }
}
