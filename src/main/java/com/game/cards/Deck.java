package com.game.cards;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Kacper Staszek
 */
public class Deck {
    private List<Card> cards;

    Deck(List<Card> cards) {
        this.cards = cards;
    }


    public Deck(){
    this.cards = new LinkedList<>();
    }

    public void addCards(List<Card> cards){
        this.cards.addAll(cards);
    }

    public void addCards(Card card){
        cards.add(card);
    }

    public Card useCard(){
        Card cardToUse = cards.get(0);
        cards.remove(0);
        return cardToUse;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getSize(){
        return cards.size();
    }
}
