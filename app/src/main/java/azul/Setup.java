package azul;

public class Setup {
    private final String[] playerNames;
    private final GameMode gameMode;

    public Setup(String[] playerNames, String gameMode) {
        for (var playerName: playerNames) {
            if(playerName == null || playerName.isEmpty()) {
                throw new IllegalArgumentException("Player name is null or empty!");
            }
        }
        this.playerNames = playerNames;
        this.gameMode = GameMode.valueOf(gameMode);
    }
    public String[] getPlayerNames() {
        return playerNames;
    }

    public GameMode getGamemode() {
        return gameMode;
    }
}
