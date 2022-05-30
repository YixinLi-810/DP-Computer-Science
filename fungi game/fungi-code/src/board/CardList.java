package board;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class CardList {
    private ArrayList<Card> cList;

    public CardList() {
        cList = new ArrayList<>();
    }

    public CardList(ArrayList<Card> cList) {
        this.cList = cList;
    }

    public void add(Card card) {
        cList.add(card);
    }
    public int size() {
        return cList.size();
    }
    public Card getElementAt(int index) {
        return cList.get(index);
    }
    public void removeElementAt(int index) {
        cList.remove(cList.size() - index);
    }

    public void view() {
        System.out.println(cList);
    }

    public String toString() {
        String cardName = "";
        for (Card card: cList) {
            cardName += card.getName();
            cardName += "|";
        }
        return cardName;

    }

    public void shuffle() {
        Collections.shuffle(cList);
    }


}
