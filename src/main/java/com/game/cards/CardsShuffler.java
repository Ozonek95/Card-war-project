package com.game.cards;

import com.game.shuffler.Shuffler;

import java.util.Collections;
import java.util.List;

/**
 * @author Kacper Staszek
 */
public class CardsShuffler implements Shuffler<Card> {
    public void shuffle(List<Card> cards){
        Collections.shuffle(cards);
    }
}
