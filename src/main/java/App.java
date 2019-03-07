import wargame.Game;

/**
 * @author Wiktor Rup
 **/

//TODO: Wydaje mi się, że powinieneś podzielić appkę na więcej pakietów - te związane z kartami i talią, logika gry, użytkownik //Kacper

public class App {


    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
