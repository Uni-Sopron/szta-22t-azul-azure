package azul;

import java.util.Arrays;

class GameEngine {
    private Bag bag;
    private Middle middle;
    private ManufactureDisk[] manufactureDisks;
    private Player[] players;
    public int startingPlayerIndex;
    public int actualPlayerIndex;

    public Player[] getPlayers() {
        return players;
    }

    public ManufactureDisk[] getManufactureDisks() {
        return manufactureDisks;
    }

    public Middle getMiddle() {
        return middle;
    }

    public Bag getBag() {
        return bag;
    }

    public void init() {
        String[] pNamesInit = new String[3];
        UIInputParser.SetupData setupData = new UIInputParser.SetupData(pNamesInit,GameMode.CLASSIC,4);
    }

    public void startGame() {}

    public Player getWinner() {
        return new Player();
    }

    public Player getCurrentPlayer() {
        return new Player();
    }

    public boolean checkWin() {
        return true;
    }
}
