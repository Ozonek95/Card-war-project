package com.game.player;

import com.game.shuffler.Shuffler;

import java.util.Collections;
import java.util.List;

/**
 * @author Kacper Staszek
 */
public class PlayerShuffler implements Shuffler<Player> {
    @Override
    public void shuffle(List<Player> toShuffle) {
        Collections.shuffle(toShuffle);
    }
}
