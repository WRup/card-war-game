package wargame;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.System.exit;

/**
 * @author Wiktor Rup
 **/
class Skirmish {
    //TODO Aga:  trudno mi tą cześć zrecenzowac i sie polapac ;C
    //TODO Patryk: Cała struktura programu jest bardzo niejasna, powinienneś przenieść klasy od danej odpowiedzialności do wybranych pakietów
    // brakuje mi również jakiegoś łącznika między deck a game, Klasa Board z polem List<Player> może być rozwiązaniem
    //TODO: Mógłbyś zrobić jedną listę STÓŁ (List<Card> table) i do niej dodawać karty obu graczy, a później wstrzykiwać cały stół, do wygranego :) czytelniejsze rozwiązanie //Kacper

    Skirmish() {
    }

    //TODO: Widzę, co tu robisz z tym typem zwracanym, ale myślę, że metoda powinna być raczej void i po prostu drukować to na ekran.
    // Zwraca String, który jakby nie patrzeć nie jest w ogóle potrzebny z punktu widzenia logiki //Kacper
    //TODO Patryk, myślę, żę cała metoda mogłabybyć znacznie krótsza lub podzielona na wiele mniejszych metod dla czytelności kodu i łatwiejszym usprawnianiu
    // w przyszłości. Brakuje mi również osobnej klasy odpowiedzialnej za interfejs użytkownika, obecnia klasa Skirmish robi wszystko, zamiast korzystać z gotowych metod innych klas
    // łącząc je w całość
    Player doBattle(Map<Player, Card> cardsOnTable) {
        Map.Entry<Player, Card> winnerPair = null;
        System.out.println("Walka kart :");
        cardsOnTable.forEach((k, v) -> {
            k.getPlayerDeck().removeCardFromDeck();
            System.out.println(k.getName() + ": " + v.getName() + " " + v.getCardColor());
        });
        for (Map.Entry<Player, Card> cardsInBattle : cardsOnTable.entrySet()) {
            if(cardsInBattle.getValue().compareTo(winnerPair.getValue()) > 0) {
                winnerPair = cardsInBattle;
            }
        }
        System.out.println("Wygrywa gracz " + winnerPair.getKey() + " z karta " + winnerPair.getValue());
        return winnerPair.getKey();
    }


    void doWar(Set<Player> playersInWar) {
        System.out.println("Karty rowne. Wojna kart :");
        playersInWar.forEach( p -> {
            System.out.println(p.getName() + ": " + p.getPlayerDeck().getCardFromDeck().getName() + " " + p.getPlayerDeck().getCardFromDeck().getCardColor());
            p.getPlayerDeck().removeCardFromDeck();
            p.getPlayerDeck().removeCardFromDeck();
        });
//        + " i " + player2.move().getName());
//        addCards();
//        if(player2.getCards().isEmpty()) {
//            System.out.println("Gracz" + player2.getName() + "przegral. Nie ma juz kart!");
//            exit(0);
//        } else if(player1.getCards().isEmpty()) {
//            System.out.println("Gracz" + player1.getName() + "przegral. Nie ma juz kart!");
//            exit(0);
//        }
//
//        //TODO: Ze stołem by było czytelniej :D //Kacper
//        player2.removeCards(1);
//        player1.removeCards(1);
//        addCards();
//        player2.removeCards(1);
//        player1.removeCards(1);
    }

    Set<Player> checkIfWar(Map<Player, Card> cardsOnTable) {
        Set<Player> players = new HashSet<>();
        for (Map.Entry<Player, Card> entry1 : cardsOnTable.entrySet()) {
            Card card1 = entry1.getValue();
            Player player1 = entry1.getKey();
            for (Map.Entry<Player, Card> entry2 : cardsOnTable.entrySet()) {
                Card card2 = entry2.getValue();
                Player player2 = entry2.getKey();
                if(card1.compareTo(card2) == 0) {
                    players.add(player1);
                    players.add(player2);
                }
            }
        }
        return players;
    }
}
