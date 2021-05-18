import java.util.Scanner;

public class Snake {

    public static String[][] playerBoard = new String[10][10];
    public static String[][] computerBoard = new String [10][10];

    public static int a;
    public static int b;

    public static int r;
    public static int c;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[]args){

        createPlayerBoard();

    }

    public static void createPlayerBoard(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                playerBoard[i][j] = "[ ]";

            }

        }

    }

    public int rowFrontOfSnake(){




        return a;
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

        //printBoard();

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

}
