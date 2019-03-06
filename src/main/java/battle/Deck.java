package battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wiktor Rup
 **/
class Deck {


    List<Card> cards;

    Deck(List<Card> cards) {
        this.cards = cards;
    }


    void shuffle(List<Card> playerCards){
        Collections.shuffle(playerCards);
    }

    List<List<Card>> splitCards(){
        shuffle(cards);
        List<Card> cardsForPlayer1 = new ArrayList<Card>();
        List<Card> cardsForPlayer2 = new ArrayList<Card>();
        List<List<Card>> cardsForPlayers = new ArrayList<List<Card>>();
        for(int i =0; i<cards.size(); i+=2){
            cardsForPlayer1.add(cards.get(i));
            cardsForPlayer2.add(cards.get(i + 1));
        }
        cardsForPlayers.add(cardsForPlayer1);
        cardsForPlayers.add(cardsForPlayer2);
        return cardsForPlayers;
    }
}
