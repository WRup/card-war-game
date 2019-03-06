package battle;

/**
 * @author Wiktor Rup
 **/
class Battle {

    Battle(){

    }

    String compareCards(Player player1, Player player2) {
        Card card1 = player1.move();
        Card card2 = player2.move();
        System.out.println("Walka kart " + card1.getName() + " i " + card2.getName());
        if(card1.getName().getValue() > card2.getName().getValue())
            return "Wygral gracz " + player1.getName() + " z karta " + card1.getName();
        else {
            return "Wygral gracz " + player2.getName() + " z karta " + card2.getName();
        }
    }

    boolean notEquals(Card player1, Card player2){
        return player1.getName().getValue() != player2.getName().getValue();
    }
}
