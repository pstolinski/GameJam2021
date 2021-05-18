public class BattleshipRunner {
    public static PlaceShips ps = new PlaceShips();
    public static Battle bl = new Battle();

    public static void main(String [] args) throws InterruptedException {
        ps.start();
        bl.start();
        System.out.println("Game Over.");
        if(Battle.winna.equals("Player")){
            System.out.println("Congratulations! You won!");
        }else if(Battle.winna.equals("Computer")){
            System.out.println("You lost. The entire fleet is gone.");
        }
    }
}
