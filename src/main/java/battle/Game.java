package battle;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

/**
 * @author Wiktor Rup
 **/
public class Game {

    public Game(){}

    public void run() {
        Card card = new Card();
        Deck deck = new Deck(card.initCards());
        Battle battle = new Battle();
        deck.shuffle(deck.cards);
        List<List<Card>> cardsForPlayer = new ArrayList<List<Card>>(deck.splitCards());
        Player player1 = new Player(cardsForPlayer.get(0), "Player1");
        Player player2 = new Player(cardsForPlayer.get(1), "Player2");

        while(true){
            if(player1.getCards().isEmpty()) {
                System.out.println("Przegral gracz" + player1.getName() + "- skonczyly mu sie karty.");
                exit(0);
            }
            if(player2.getCards().isEmpty()){
                System.out.println("Przegral gracz" + player2.getName() + "- skonczyly mu sie karty.");
                exit(0);
            }
            if(battle.notEquals(player1.move(), player2.move())){
                System.out.println(battle.compareCards(player1, player2));
                player1.removeCard();
                player2.removeCard();
            }
            else {
                System.out.println("Karty rowne. Nie ma zwyciezcy. Tasowanie kart i ponowe zagranie.");
                deck.shuffle(player1.getCards());
                deck.shuffle(player2.getCards());
            }
        }


    }


}