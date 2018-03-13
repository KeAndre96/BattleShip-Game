import java.util.*;
public class Battleship{
    public static void main(String[] args){
        Random r = new Random();
        
        // set up battleship board
        char[][] board = new char[5][5];
        for(int row = 0; row < board.length; row++) //board.length == num rows
		{
            for(int col = 0; col < board[row].length; col++)
			{
                board[row][col] = 'O';
			}
        }
        // displays the board
        printBoard(board);
          
        // gets the ship
        /* generates a random number for the row
         * and for the column
         */
        int shipRow = r.nextInt(board.length);
        int shipCol = r.nextInt(board.length);
        
        Scanner kb = new Scanner(System.in);
        int guessRow;
        int guessCol;
        
        // only allowed 3 guesses
        int turns = 3;
        
        System.out.println("You have " + turns + " turns to guess.");
        
        // loop through each of the turns
        // and allows the user to make a guess


        for(int i = 1; i <= turns; i++)
        {
            System.out.println("Turn " + i);
            System.out.print("Guess a row: ");
            guessRow = kb.nextInt();
        
            System.out.print("Guess a column: ");
            guessCol = kb.nextInt();    
            
            // if they correctly guess the row and column of the ship
            // the loop quits (line 46)        
            if(guessRow == shipRow && guessCol == shipCol)
			{
                System.out.println("You sunk my battleship!");
                break;
            }
            
            // using a nested if statement to test the non-winning conditions
            // a message is displayed if they guess outside the boundaries of the board
            else
			{
                if((guessRow < 0 || guessRow > board.length) || (guessCol < 0 || guessCol > board.length))
				{
                    System.out.println("That's not even in the ocean!");
                }
                // current guesses are indicated by an X, if an X is found at that location
                // the user made that guess previously
                else if (board[guessRow][guessCol] == 'X')
				{
                    System.out.println("You've already guessed that one!");
				}
                // otherwise, the coordinate of the guess should be marked with an X
                else
				{
                    System.out.println("You missed my battleship.");
                    board[guessRow][guessCol] = 'X';
                }
            }
            // display the board again (with the X's this time)
            printBoard(board);
        }
        System.out.println("Game Over."); // all turns used, game is over
        board[shipRow][shipCol] = '*'; // so that we can see where the battleship actually is
        printBoard(board); // prints the board again with the location of the battleship
    }
    
    // Method used to display the board as a grid
    public static void printBoard(char[][] board)
	{
       for(int row = 0; row < board.length; row++)
	   {
           for(int col = 0; col < board[row].length; col++)
		   {
               System.out.print(board[row][col] + " "); // this line prints the row
           }
           System.out.println(); // moves the cursor underneath the previous row to print the new one
       }
    }
}