package wargame;

/**
 * @author Wiktor Rup
 **/
class Card implements Comparable<Card> {

    private CardName name;
    private CardColor cardColor;

    Card(CardName name, CardColor cardColor) {
        this.name = name;
        this.cardColor = cardColor;
    }

    Card() {

    }

    public CardName getName() {
        return name;
    }

    public int getValue(){
        return name.getValue();
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Card)) {
            return false;
        }

        Card card = (Card) o;

        return name.getValue() == card.name.getValue();
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Card o) {
        if(this.equals(o)) {
            return 0;
        } else if(this.name.getValue() > o.name.getValue()) {
            return 1;
        } else {
            return -1;
        }
    }
}
