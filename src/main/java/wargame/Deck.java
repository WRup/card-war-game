package wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Wiktor Rup
 **/
class Deck implements DeckGenerator {


    List<Card> cards;

    Deck(List<Card> cards) {
        this.cards = cards;
    }

    Deck() {
    }

    Deck shuffle(Deck deck) {
        Collections.shuffle(deck.cards);
        return deck;
    }

    List<Deck> deal(int numberOfPlayers) {
        List<Deck> cardsForPlayers = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            cardsForPlayers.add(new Deck());
        }
        for (int i = 0; i < cards.size(); i++) {
            for(int j = 0; j< cardsForPlayers.size(); j++){
                cardsForPlayers.get(j).cards.add(this.cards.get(i+j));
            }
        }
        return cardsForPlayers;
    }

    void addCardsToDeck(List<Card> cards){
        this.cards.addAll(cards);
    }

    void removeCardFromDeck(){
        //Card card = cards.get(0);
        cards.remove(0);
       // return card;
    }

    Card getCardFromDeck(){
        return cards.get(0);
    }

    void removeDeck(){
        cards.clear();
    }
}
