package com.game.shuffler;

import java.util.List;

/**
 * @author Kacper Staszek
 */
public interface Shuffler<T> {
     void shuffle(List<T> toShuffle);//TODO PATRYK do you even need such interface? deck can have such method, Aga: tez mi sie tak wydaje Wiktor : same here :D
}
