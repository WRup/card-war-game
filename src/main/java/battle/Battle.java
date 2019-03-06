package battle;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

/**
 * @author Wiktor Rup
 **/
class Battle {

    private Player player1;
    private Player player2;
    private List<Card> p1BattleCards;
    private List<Card> p2BattleCards;

    Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        p1BattleCards = new ArrayList<Card>();
        p2BattleCards = new ArrayList<Card>();
    }

    String compareCards() {

        List<Card> player1Cards = player1.getCards();
        List<Card> player2Cards = player2.getCards();
        Card card1 = player1.move();
        Card card2 = player2.move();
        addCards();
        player1.removeCards(1);
        player2.removeCards(1);
        System.out.println("Walka kart " + card1.getName() + " i " + card2.getName());
        if (card1.getName().getValue() > card2.getName().getValue()) {
            player1Cards.addAll(p2BattleCards);
            player1Cards.addAll(p1BattleCards);
            player1.setCards(player1Cards);
            //player2.removeCards(p2BattleCards.size());
            p1BattleCards.clear();
            p2BattleCards.clear();
            return "Wygral gracz " + player1.getName() + " z karta " + card1.getName();
        } else {
            player2Cards.addAll(p1BattleCards);
            player2Cards.addAll(p2BattleCards);
            player2.setCards(player2Cards);
            //player1.removeCards(p1BattleCards.size());
            p1BattleCards.clear();
            p2BattleCards.clear();
            return "Wygral gracz " + player2.getName() + " z karta " + card2.getName();
        }
    }

    boolean notEquals(Card player1, Card player2) {
        return player1.getName().getValue() != player2.getName().getValue();
    }

    void battle() {
        System.out.println("Karty rowne. Wojna kart " + player1.move().getName() + " i " + player2.move().getName());
        addCards();
        if(player2.getCards().isEmpty()){
            System.out.println("Gracz" + player2.getName() + "przegral. Nie ma juz kart!");
            exit(0);
        }
        else if(player1.getCards().isEmpty()){
            System.out.println("Gracz" + player1.getName() + "przegral. Nie ma juz kart!");
            exit(0);
        }
        player2.removeCards(1);
        player1.removeCards(1);
        addCards();
        player2.removeCards(1);
        player1.removeCards(1);
    }

    void addCards() {
        p2BattleCards.add(player1.move());
        p1BattleCards.add(player2.move());
    }
}
