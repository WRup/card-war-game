package wargame;

import java.util.stream.Stream;

/**
 * @author Wiktor Rup
 **/
public enum CardName {

    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(8), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(
            14), JOKER(15);


    public int getValue() {
        return value;
    }

    private final int value;


    CardName(int value) {
        this.value = value;
    }}
