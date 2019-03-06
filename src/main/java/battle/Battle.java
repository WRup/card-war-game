package battle;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

/**
 * @author Wiktor Rup
 **/
class Battle {
    //TODO Aga:  trudno mi tą cześć zrecenzowac i sie polapac ;C
//TODO Patryk: Cała struktura programu jest bardzo niejasna, powinienneś przenieść klasy od danej odpowiedzialności do wybranych pakietów
// brakuje mi również jakiegoś łącznika między deck a game, Klasa Board z polem List<Player> może być rozwiązaniem
//TODO: Mógłbyś zrobić jedną listę STÓŁ (List<Card> table) i do niej dodawać karty obu graczy, a później wstrzykiwać cały stół, do wygranego :) czytelniejsze rozwiązanie //Kacper
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
//TODO: Widzę, co tu robisz z tym typem zwracanym, ale myślę, że metoda powinna być raczej void i po prostu drukować to na ekran.
// Zwraca String, który jakby nie patrzeć nie jest w ogóle potrzebny z punktu widzenia logiki //Kacper
    //TODO Patryk, myślę, żę cała metoda mogłabybyć znacznie krótsza lub podzielona na wiele mniejszych metod dla czytelności kodu i łatwiejszym usprawnianiu
    // w przyszłości. Brakuje mi również osobnej klasy odpowiedzialnej za interfejs użytkownika, obecnia klasa Battle robi wszystko, zamiast korzystać z gotowych metod innych klas
    // łącząc je w całość
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

        //TODO: Ze stołem by było czytelniej :D //Kacper
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
