package azul;
import java.util.Scanner;

public class InputParser {

    public static void main(String[] args) {
        System.out.println("InputParser work ...");

        String[] s;
        s = new String[]{"Player1", "Player2"};

        SetupData setupData = new SetupData(s,GameMode.CLASSIC,2);
        setupData.parseSetup();
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
                    System.out.println("Enter the name of player " + i + ". :");
                    playerNames[i] = sc.nextLine();
                } while( !isValidName(playerNames[i]));
            }

            String gm;
            do {
                System.out.println("Enter the type of gamemode: \n> Classic: CLASSIC\n> Alternative: ALTERNATIVE");
                gm = sc.nextLine();
            } while( !isValidGamemode(gm));
            return new SetupData(playerNames, gameMode, playerNumber);
        }

        private boolean isValidPlayerNumber(int pNumber){
            if(pNumber > 4 || pNumber  < 2){
                System.out.println("The value must be between 2-4!" );
                return false;
            }  else return true;
        }

        private boolean isValidName(String name){
            if(name.isEmpty()){
                System.out.println("Wrong name!" );
                return false;
            }  else return true;
        }

        private boolean isValidGamemode(String mode){
            if(mode == "CLASSIC" || mode == "ALTERNATIVE"){
                System.out.println("The value should be CLASSIC or ALTERNATIVE!");
                return false;
            }  else return true;
        }
    }
}
