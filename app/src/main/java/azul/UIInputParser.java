package azul;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import azul.interfaces.AzulUI;

public class UIInputParser implements AzulUI {

    private ArrayList<String> playerNames;
    private Scanner sc;
    final private boolean testMode;

    public UIInputParser(InputStream in) {
        this.sc = new Scanner(in);
        testMode = sc.hasNext();
    }

    public int getSelectedRow() {
        int rowNumber = -1;
        String fromConsole = "";
        do {
            System.out.println("Enter row index between 0-5 inclusive, 0 is floor:");
            try {
                fromConsole = sc.next();
                Integer.parseInt(fromConsole);
                rowNumber = Integer.parseInt(fromConsole);
            } catch (Exception e) {
                System.out.println("Please enter numbers.");
                fromConsole = "";
                if(testMode) {
                    throw new IllegalArgumentException();
                }
            }
        } while (!(rowNumber >= 0 && rowNumber <= 5));
        return (rowNumber - 1);
    }

    public static void StartIP(String[] args) {
        System.out.println("InputParser work ...");

        String[] s;
        s = new String[] { null, null, null, null };

        SetupData setupData = new SetupData(s, GameMode.CLASSIC, 4);
        setupData = setupData.parseSetup();
        System.out.println(setupData);
    }

    static class SetupData {

        private String[] playerNames;
        private GameMode gameMode;
        private Integer playerNumber;

        public SetupData(String[] playerNames, GameMode gameMode, Integer playerNumber) {
            this.playerNames = playerNames;
            this.gameMode = gameMode;
            this.playerNumber = playerNumber;
        }

        static Scanner sc = new Scanner(System.in);

        public SetupData parseSetup() {
            do {
                System.out.println("Enter the number of players: ");
                this.playerNumber = sc.nextInt();
            } while (!isValidPlayerNumber(playerNumber));

            for (int i = 0; i < playerNumber; i++) {
                do {
                    System.out.println("Enter the name of player " + (i + 1) + ". :");
                    playerNames[i] = sc.nextLine();
                } while (!isValidName(playerNames[i]));
            }

            int gmType = 0;
            do {
                System.out.println("Enter the number of gamemode: \n> 1: classic mode\n> 2: alternative mode");
                gmType = sc.nextInt();
                if (gmType == 1) {
                    gameMode = GameMode.CLASSIC;
                }
                if (gmType == 2) {
                    gameMode = GameMode.ALTERNATIVE;
                }
            } while (!isValidGameMode(gmType));

            return new SetupData(playerNames, gameMode, playerNumber);
        }

        private boolean isValidGameMode(int pNumber) {
            if (pNumber == 1 || pNumber == 2) {
                return true;
            } else {
                System.out.println("The value must be between 1-2!");
                return false;
            }
        }

        private boolean isValidPlayerNumber(int pNumber) {
            if (pNumber > 4 || pNumber < 2) {
                System.out.println("The value must be between 2-4!");
                return false;
            } else
                return true;
        }

        private boolean isValidName(String name) {
            if (name == null || name.isEmpty()) {
                System.out.println("Wrong name!");
                return false;
            } else
                return true;
        }
    }

    @Override
    public void drawState() {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawScoreboard() {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public List<String> getPlayerNames() {
        int playerNumber = -1;
        String fromConsole = "";
        do {
            System.out.println("Enter the number of players (2-4):");
            try {
                fromConsole = sc.next();
                Integer.parseInt(fromConsole);
                playerNumber = Integer.parseInt(fromConsole);
            } catch (Exception e) {
                System.out.println("Please enter numbers.");
                fromConsole = "";
                if(testMode) {
                    throw new IllegalArgumentException();
                }
            }
        } while (!(playerNumber >= 2 && playerNumber <= 4));
        ArrayList<String> names = new ArrayList<String>();
        byte index = 0;
        do {
            System.out.println("Enter a name:");
            try {
                fromConsole = sc.next();
                names.add(index, fromConsole);
                index++;
            } catch (Exception e) {
                System.out.println("Please a valid name.");
                if(testMode) {
                    throw new IllegalArgumentException();
                }
            }
        } while (index < playerNumber);
        playerNames = names;
        return names;
    }

    @Override
    public GameMode getGameMode() {
        String fromConsole;
        GameMode chosenGameMode = null;
        boolean isOk = false;
        do {
            System.out.println("Possible game modes yet: CLASSIC, ALTERNATIVE");
            System.out.println("Enter a game mode:");
            try {
                fromConsole = sc.next();
                chosenGameMode = GameMode.valueOf(fromConsole);
                isOk = true;
            } catch (Exception e) {
                System.out.println("Please a valid game mode.");
                isOk = false;
                if(testMode) {
                    throw new IllegalArgumentException();
                }
            }
        } while (!isOk);
        return chosenGameMode;
    }

    @Override
    public String getTileHolderId() {
        String fromConsole = "";
        boolean isOk = false;
        do {
            System.out.println("Please enter a valid Tile holder ID");
            try {
                fromConsole = sc.next();
                if (fromConsole.equals("Middle1")) {
                    return fromConsole;
                }
                if (fromConsole.length() == 16 && fromConsole.startsWith("ManufactureDisk")) {
                    int num = Integer.parseInt(fromConsole.substring(fromConsole.length() - 1));
                    if (playerNames.size() == 2 && num >= 1 && num <= 5) {
                        isOk = true;
                    }
                    if (playerNames.size() == 3 && num >= 1 && num <= 7) {
                        isOk = true;
                    }
                    if (playerNames.size() == 4 && num >= 1 && num <= 9) {
                        isOk = true;
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                isOk = false;
                if(testMode) {
                    throw new IllegalArgumentException();
                }
            }
        } while (!isOk);
        return fromConsole;
    }

    @Override
    public Color getColor() {
        String fromConsole;
        Color chosenColor = null;
        boolean isOk = false;
        do {
            System.out.println("Possible colors yet: WHITE, RED, GREEN, BLUE, YELLOW");
            System.out.println("Enter a color:");
            try {
                fromConsole = sc.next();
                if (!Color.FIRSTPLAYER.name().equals(fromConsole)) {
                    chosenColor = Color.valueOf(fromConsole);
                    isOk = true;
                }
            } catch (Exception e) {
                System.out.println("Please a valid color.");
                isOk = false;
                if(testMode) {
                    throw new IllegalArgumentException();
                }
            }
        } while (!isOk);
        return chosenColor;
    }
}
