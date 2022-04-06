package hu.azul;

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

    public void init() {}

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
