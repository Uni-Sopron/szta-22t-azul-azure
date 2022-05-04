package azul;
import java.util.Scanner;

public class InputParser {

    public static void main(String[] args) {
        System.out.println("InputParser work ...");

        String[] s;
        s = new String[]{null, null, null, null};

        SetupData setupData = new SetupData(s,GameMode.CLASSIC,4);
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
            } while( !isValidPlayerNumber(playerNumber) );

            for(int i = 0; i<playerNumber; i++) {
                do {
                    System.out.println("Enter the name of player " + (i+1) + ". :");
                    playerNames[i] = sc.nextLine();
                } while( !isValidName(playerNames[i]));
            }

            int gmType = 0;
            do {
                System.out.println("Enter the number of gamemode: \n> 1: classic mode\n> 2: alternative mode");
                gmType = sc.nextInt();
                if(gmType == 1) {
                    gameMode = GameMode.CLASSIC;
                }
                if(gmType == 2) {
                    gameMode = GameMode.ALTERNATIVE;
                }
            } while( !isValidGameMode(gmType));

            return new SetupData(playerNames, gameMode, playerNumber);
        }

        private boolean isValidGameMode(int pNumber){
            if(pNumber == 1 || pNumber == 2) {
                return true;
            }  else {
                System.out.println("The value must be between 1-2!");
                return false;
            }
        }

        private boolean isValidPlayerNumber(int pNumber){
            if(pNumber > 4 || pNumber  < 2){
                System.out.println("The value must be between 2-4!" );
                return false;
            }  else return true;
        }

        private boolean isValidName(String name){
            if(name == null || name.isEmpty()){
                System.out.println("Wrong name!" );
                return false;
            }  else return true;
        }
    }
}
