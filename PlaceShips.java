import java.util.Scanner;
import java.util.Random;

public class PlaceShips{

    public static String[][] playerBoard = new String[10][10];
    public static String[][] computerBoard = new String [10][10];

    //PATRICK EDIT
    public static Opponent o = new Opponent();

    public static int r;
    public static int c;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        String message = "Welcome Aboard, Captain! |You've joined us just in time. |The Commie Japs are attacking Guam, |and we need your help!";

        for(int p = 0; p < message.length(); p++){

            String character  = Character.toString(message.charAt(p));

            if(character.equalsIgnoreCase("|")){
                System.out.println("");
                Thread.sleep(500);

            }else {
                System.out.print(message.charAt(p));
                Thread.sleep(20);

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

        int r1 = r+1;
        int r2 = r1+1;
        int r3 = r2+1;
        int r4 = r3+1;

        playerBoard[r][c] = "[█]";
        playerBoard[r+1][c] = "[█]";
        playerBoard[r+2][c] = "[█]";
        playerBoard[r+3][c] = "[█]";
        playerBoard[r+4][c] = "[█]";

        printBoard();

        String set = sc.nextLine();

        if(set.equalsIgnoreCase("W")){

            r = r-1;
            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("A")){

            c = c-1;
            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("S")){

            r = r+1;
            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("D")){

            c = c+1;
            createPlayerBoard();
            playerPlaceShips();

        }else if(set.equalsIgnoreCase("R")) {

            int temp = c;
            c = r;
            r = temp;
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
        o.placeOpponentShips();

    }

    public static void printBoard(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                System.out.print(playerBoard[i][j]);

            }
            System.out.println("");
        }

    }

}