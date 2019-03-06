package com.game.cards;

import java.util.Objects;

/**
 * @author Kacper Staszek
 */
public class Card {
    private final Color color;
    private final CardValue value;

    Card(Color color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return value+" "+color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return color == card.color &&
                value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, value);
    }

    public int getValue() {
        return value.getValue();
    }
}
