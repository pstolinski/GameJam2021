import java.util.Random;
public class Opponent {
    public static Random r = new Random();
    /**
     * 5 ships need to be randomly placed of lengths:
     * - 1 at 5 long
     * - 1 at 4 long
     * - 2 at 3 long
     * - 1 at 2 long
     * playerBoard[r+4][c] = "[█]";
     */
    public static void placeOpponentShips(){
        String [] directions = {"Up", "Down", "Left", "Right"};
        int rSize = PlaceShips.computerBoard.length;
        int cSize = PlaceShips.computerBoard[0].length;
        int basePoint = r.nextInt(10);
        for(int i = 0; i < 5; i++){
            int whatDirection = r.nextInt(4);
            if(directions[whatDirection].equals("Up")){

            }
        }
    }
}
