import java.util.Scanner;

public class Animator {

    public static String[][] grid = new String[10][10];

    public static void main(String[] args) throws InterruptedException {

        buildGrid();
        animate();
        printGrid();

    }

    public static void buildGrid(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                grid[i][j] = "[ ]";

            }
        }

    }

    public static void printGrid(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                System.out.print(grid[i][j]);

            }

            System.out.println("");

        }

    }

    public static void placeSprite(int r, int c){

        grid[r][c] = "[O]";

    }

    public static void animate() throws InterruptedException{

        for(int g = 0; g < 10; g++){

            Thread.sleep(200);
            placeSprite(0,g);
            printGrid();

        }


    }



}


