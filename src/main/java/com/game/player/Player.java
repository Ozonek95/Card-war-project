package com.game.player;

import com.game.cards.Deck;

/**
 * @author Kacper Staszek
 */
public class Player {
    private Deck deck;
    private String name;

    public Player(){
        this.deck=new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
