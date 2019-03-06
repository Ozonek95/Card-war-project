package com.game.com.game.logic;

import com.game.cards.Card;
import com.game.player.Player;

/**
 * @author Kacper Staszek
 */

//TODO:FUTURE CLASS TO HANDLE MULTIPLE PLAYERS PLAYING
public class Move {
    private Player player;
    private Card card;

    public Move(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }
}
