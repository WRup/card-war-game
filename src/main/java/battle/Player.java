package battle;

import java.util.List;

/**
 * @author Wiktor Rup
 **/
public class Player {

    List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    private List<Card> cards;

    String getName() {
        return name;
    }

    private String name;

    Player(List<Card> cards, String name) {
        this.cards = cards;
        this.name = name;
    }

    Card move(){
        return cards.get(0);
    }

    void removeCards(int numberOfCards){
        if(numberOfCards==1) cards.remove(0);
        else {
            for (int i = 0; i < numberOfCards; i++)
                cards.remove(i);
        }
    }
}
