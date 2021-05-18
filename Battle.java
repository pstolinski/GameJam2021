import java.util.Scanner;
import java.util.Random;

public class Battle {
    private static boolean winner = false;
    public static String winna;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    private static String [][] userGuesses = new String[PlaceShips.playerBoard.length][PlaceShips.playerBoard[0].length];
    private static String [][] compGuesses = new String[PlaceShips.playerBoard.length][PlaceShips.playerBoard[0].length];

    public static void start(){
        for(int i = 0; i < PlaceShips.playerBoard.length; i++){
            for(int j = 0; j < PlaceShips.playerBoard[0].length; j++){
                userGuesses[i][j] = "[ ]";
                compGuesses[i][j] = "[ ]";
            }
        }
        while(!winner){
            placeHumanMove();
            placeComputerMove();
            checkWin();
            printGuesses();
        }
    }

    public static void placeHumanMove(){
        System.out.println("Your move.");
        System.out.print("\nRow: ");
        int hRow = sc.nextInt()-1;
        System.out.print("\nCol: ");
        int hCol = sc.nextInt()-1;
        if((hRow >= 0 && hRow < PlaceShips.playerBoard.length) && (hCol >= 0 && hCol < PlaceShips.playerBoard[0].length)){
            if(PlaceShips.computerBoard[hRow][hCol].equals("[█]")){
                System.out.println("HIT!");
                PlaceShips.computerBoard[hRow][hCol] = "[ ]";
                userGuesses[hRow][hCol] = "[" + ANSI_RED + "█" + ANSI_RESET + "]";
            }else{
                if(userGuesses[hRow][hCol].equals("[" + ANSI_RED + "█" + ANSI_RESET + "]")){
                    System.out.println("You've already fired here!");
                    userGuesses[hRow][hCol] = "[" + ANSI_RED + "█" + ANSI_RESET + "]";
                }else {
                    System.out.println("Miss!");
                    userGuesses[hRow][hCol] = "[█]";
                }
            }
        }else{
            System.out.println("Invalid choice! Out of bounds.");
        }
    }

    public static void placeComputerMove(){
        int rRow = r.nextInt(PlaceShips.playerBoard.length);
        int rCol = r.nextInt(PlaceShips.playerBoard[0].length);
        while(compGuesses[rRow][rCol].equals("[█]")) {
            rRow = r.nextInt(PlaceShips.playerBoard.length);
            rCol = r.nextInt(PlaceShips.playerBoard[0].length);
        }
        if(PlaceShips.playerBoard[rRow][rCol].equals("[█]")){
            System.out.println("You've been hit!");
            PlaceShips.playerBoard[rRow][rCol] = "[ ]";
        }
        compGuesses[rRow][rCol] = "[█]";
    }

    public static void checkWin(){
        int pCount = 0;
        for(int i = 0; i < PlaceShips.playerBoard.length; i++){
            for(int j = 0; j < PlaceShips.playerBoard[0].length; j++){
                if(PlaceShips.playerBoard[i][j].equals("[█]")){
                    pCount++;
                }
            }
        }

        int cCount = 0;
        for(int i = 0; i < PlaceShips.computerBoard.length; i++){
            for(int j = 0; j < PlaceShips.computerBoard[0].length; j++){
                if(PlaceShips.computerBoard[i][j].equals("[█]")){
                    cCount++;
                }
            }
        }
        if(pCount == 0){
            winner = true;
            winna = "Computer";
        }
        if(cCount == 0){
            winner = true;
            winna = "Player";
        }
    }

    public static void printGuesses(){
        System.out.println("Here are your guesses:");
        System.out.println();
        System.out.print("   ");
        for(int i = 1; i <= 10; i++){
            System.out.print(" "+ i + " ");
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            if(i != 9) {
                System.out.print(" " + (i+1) + " ");
            }else{
                System.out.print((i+1) + " ");
            }
            for(int j = 0; j < 10; j++){
                System.out.print(userGuesses[i][j]);
            }
            System.out.println();
        }
    }
}