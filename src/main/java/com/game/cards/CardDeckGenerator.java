package com.game.cards;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Kacper Staszek
 */
public class CardDeckGenerator implements DeckGenerator {
    //TODO:private static final int DECK_SIZE = 52;// FOR FUTURE DECK SIZE OPTION
    private static final Color[] colors = Color.values();
    private static final CardValue[] cardValues = CardValue.values();
    public Deck generateCards(int numberOfDeck){
        if(numberOfDeck<1){
            throw new IllegalArgumentException("Number of decks must be positive.");
        }
        List<Card> cardsToReturn = new LinkedList<>();
        for (Color color: colors) {
            for (CardValue cardValue: cardValues){
                if(cardValue.equals(CardValue.JOKER)){
                    continue;
                }
                cardsToReturn.add(new Card(color,cardValue));
            }
        }
        cardsToReturn.add(new Card(Color.CLUB,CardValue.JOKER));//TODO Patryk does a Joker has always to be a CLUB
        cardsToReturn.add(new Card(Color.CLUB,CardValue.JOKER));
        return new Deck(cardsToReturn);
    }
}
