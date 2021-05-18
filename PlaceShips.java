import java.util.Scanner;
import java.util.Random;

public class PlaceShips{

    public static String[][] playerBoard = new String[10][10];
    public static String[][] computerBoard = new String [10][10];

    public static int r;
    public static int c;

    public static int r1 = r+1;
    public static int r2 = r1+1;
    public static int r3 = r2+1;
    public static int r4 = r3+1;

    public static int c1 = c;
    public static int c2 = c;
    public static int c3 = c;
    public static int c4 = c;

    public static Scanner sc = new Scanner(System.in);

    public static Opponent oppo = new Opponent();

    public static void start() throws InterruptedException {

        String message = "Welcome Aboard, Captain! |You've joined us just in time. |The Commie Japs are attacking Guam, |and we need your help!";

        for(int p = 0; p < message.length(); p++){

            String character  = Character.toString(message.charAt(p));

            if(character.equalsIgnoreCase("|")){
                System.out.println("");
                Thread.sleep(0);//500

            }else {
                System.out.print(message.charAt(p));
                Thread.sleep(0);//20

            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Start? (Y/N)");
        String start = sc.nextLine();

        if(start.equalsIgnoreCase("Y") || start.equalsIgnoreCase("yes")) {

            createPlayerBoard();
            printBoard();

            System.out.println("Place Carrier: WASD + ENTER to move");
            System.out.println("r + ENTER to rotate");
            System.out.println("Type 'SET' and hit ENTER to set");
            System.out.println("");
            System.out.println("");

            playerPlaceShips();
            createComputerBoard();

        }else{

            System.out.println("Why Are You Here?");

        }
    }

    public static void createPlayerBoard(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                playerBoard[i][j] = "[ ]";

            }

        }

    }

    public static void playerPlaceShips(){

        playerBoard[r][c] = "[█]";
        playerBoard[r1][c1] = "[█]";
        playerBoard[r2][c2] = "[█]";
        playerBoard[r3][c3] = "[█]";
        playerBoard[r4][c4] = "[█]";

        printBoard();

        String set = sc.nextLine();

        if(set.equalsIgnoreCase("W")){

            r = r-1;
            r1 = r1-1;
            r2 = r2-1;
            r3 = r3-1;
            r4 = r4-1;

            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("A")){

            c = c-1;
            c1 = c1 - 1;
            c2 = c2 - 1;
            c3 = c3 - 1;
            c4 = c4 - 1;

            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("S")){

            r = r+1;
            r1 = r1 + 1;
            r2 = r2 + 1;
            r3 = r3 + 1;
            r4 = r4 + 1;

            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("D")){

            c = c+1;
            c1 = c1 + 1;
            c2 = c2 + 1;
            c3 = c3 + 1;
            c4 = c4 + 1;

            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("R")) {

            int temp1 = c;
            int temp2 = c1;
            int temp3 = c2;
            int temp4 = c3;
            int temp5 = c4;

            c = r;
            c1 = r1;
            c2 = r2;
            c3 = r3;
            c4 = r4;

            r = temp1;
            r1 = temp2;
            r2 = temp3;
            r3 = temp4;
            r4 = temp5;

            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("SET")){

        }else{
            System.out.println("Not a valid option");
            playerPlaceShips();
        }




    }

    public static void createComputerBoard(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                computerBoard[i][j] = "[ ]";

            }

        }
        //this works as intended
        oppo.placeOpponentShips();

    }

    public static void printBoard(){
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
                System.out.print(playerBoard[i][j]);
            }
            System.out.println();
        }
    }
}