package wargame;

import java.util.HashMap;
import java.util.Map;

public class Table {


    private Deck inactiveCards = new Deck();
    private Map<Player, Card> activeCards = new HashMap<>();

    Table() {
    }


    void putCardOnTheTable(Player player, Card card) {
        activeCards.put(player, card);
    }

    Deck getCardsFromTheTable() {
        return inactiveCards;
    }

    void clearTable() {
        inactiveCards.removeDeck();
    }

    Map<Player, Card> getActiveCards(){
        return activeCards;
    }

}
