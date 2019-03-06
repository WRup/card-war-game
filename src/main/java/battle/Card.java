package battle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wiktor Rup
 **/
class Card {

    CardName getName() {
        return name;
    }

    private CardName name;
    private Color color;

    Card(CardName name, Color color) {
        this.name = name;
        this.color = color;
    }

    Card(){

    }

    List<Card> initCards(){
        List<Card> cards = new ArrayList<Card>();
        for(Color color: Color.values()){
            for(CardName cardName: CardName.values()){
                if(cardName.equals(CardName.JOKER))
                    continue;
                else
                    cards.add(new Card(cardName,color));
            }
        }
        cards.add(new Card(CardName.JOKER, Color.CLUB));
        cards.add(new Card(CardName.JOKER, Color.CLUB));

        return cards;
    }
}
