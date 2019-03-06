package com.game.cards;

/**
 * @author Kacper Staszek
 */

//TODO:: Wiktor - dlaczego interfejs z jedna metoda, ktory implementuje tylko jenda klasa?
public interface DeckGenerator {
     Deck generateCards(int numberOfDeck);
}
