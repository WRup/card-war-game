package wargame;

import java.util.ArrayList;
import java.util.List;

public interface DeckGenerator {

    //TODO:: Fulfill methods later on
//    Deck generateRandomDeck(int numberOfCards);
//
//    Deck generate24Deck(int numberOfDecks);

    default Deck generate52Deck(int numberOfDecks) {
        List<Card> cards = new ArrayList<>();
        for (CardColor cardColor : CardColor.values()) {
            for (CardName cardName : CardName.values()) {
                if(!cardName.equals(CardName.JOKER)) {
                    cards.add(new Card(cardName, cardColor));
                }
            }
        }
        cards.add(new Card(CardName.JOKER, CardColor.DIAMOND));
        cards.add(new Card(CardName.JOKER, CardColor.CLUB));

        return new Deck(cards);
    }
}
