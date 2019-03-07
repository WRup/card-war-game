package wargame;

/**
 * @author Wiktor Rup
 **/
class Player {

    private String name;
    private Deck playerDeck;

    Player(Deck playerDeck, String name) {
        this.playerDeck = playerDeck;
        this.name = name;
    }

    String getName() {
        return name;
    }

    public Deck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(Deck playerDeck) {
        this.playerDeck = playerDeck;
    }
}
