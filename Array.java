import java.util.Scanner;
public class Array
{
    //call the main method of this class from the runner class
    public static void main(String[] args)
    {
        Board();
    }

    public static String[] [] Board()
    {
        Scanner s = new Scanner(System.in);
        
        String[][]BattleLines = new String[10] [10];
        for(int i = 0; i < BattleLines.length; i++)
        {
            for(int j = 0; j < BattleLines[0].length; j++)
            {
                System.out.print(" [ " + BattleLines[i][j] + " ] ");
            }
            System.out.println();
        }
        return BattleLines;
        
        //runner class; UI built, call the bool like this, put an else statement to call the main method again and prrint try again
        System.out.println("Enter your missile coordinates, type the row first");
        int a = s.nextInt();
        System.out.println("Enter your missile coordinates, type the column now");
        int b = s.nextInt();
        
        if(isSunk(a, b))
        {
            System.out.println("You win!");
        }
        //else{call main or this method};
    }

    public bool isSunk(int a, int b)
    {
        if(BattleLines[a][b].equals(" "))
        {
            return true;
        }
        return false;
    }

}
