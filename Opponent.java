import java.util.Random;
public class Opponent {
    public static Random r = new Random();

    public static void placeOpponentShips(){
        int [] shipSizes = {5, 4, 3, 3, 2};
        int rSize = PlaceShips.computerBoard.length;
        int cSize = PlaceShips.computerBoard[0].length;
        for(int i = 0; i < 5; i++){
            while(true) {
                int bpRow = r.nextInt(10);
                int bpCol = r.nextInt(10);
                int whatDirection = r.nextInt(4);
                if (whatDirection == 3) {
                    if (shipSizes[i] <= (bpRow + 1)) {
                        for(int j = bpRow; j > bpRow-shipSizes[i]; j--){
                            PlaceShips.computerBoard[j][bpCol] = "[█]";
                        }
                        break;
                    }
                }
                if (whatDirection == 1) {
                    if ((rSize - 1) - bpRow >= shipSizes[i]) {
                        for(int j = bpRow; j < bpRow + shipSizes[i]; j++){
                            PlaceShips.computerBoard[j][bpCol] = "[█]";
                        }
                        break;
                    }
                }
                if (whatDirection == 2) {
                    if (bpCol >= shipSizes[i]) {
                        for(int j = bpCol; j > bpCol-shipSizes[i]; j--){
                            PlaceShips.computerBoard[bpRow][j] = "[█]";
                        }
                        break;
                    }
                }
                if (whatDirection == 3) {
                    if ((cSize - 1) - bpCol >= shipSizes[i]) {
                        for(int j = bpCol; j < bpCol+shipSizes[i]; j++){
                            PlaceShips.computerBoard[j][bpCol] = "[█]";
                        }
                        break;
                    }
                }
            }
        }
    }
}