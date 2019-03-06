package com.game.player;

import com.game.cards.Card;
import com.game.cards.CardsShuffler;
import com.game.cards.Deck;
import com.game.shuffler.Shuffler;

import java.util.List;

/**
 * @author Kacper Staszek
 */
public class PlayerDeckGenerator {
    private Deck startingDeck;
    private List<Player> players;
    private Shuffler<Card> cardShuffler = new CardsShuffler();
    private Shuffler<Player> playerShuffler = new PlayerShuffler();

    public void giveCardsToPlayers(){
        cardShuffler.shuffle(startingDeck.getCards());
        playerShuffler.shuffle(players);
        int counter = 0;
       for (Card card:startingDeck.getCards()){
           players.get(counter).getDeck().addCards(card);
           counter++;
           if(counter>players.size()-1){
               counter=0;
           }

       }
    }

    public PlayerDeckGenerator(Deck startingDeck, List<Player> players) {
        this.startingDeck = startingDeck;
        this.players = players;
    }
}
