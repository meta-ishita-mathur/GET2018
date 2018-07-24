package N_Queens;

/**
 *this class is used to check whether queen's problem can be solved for the given dimension
 * @author Ishita_Mathur
 *
 */
public class NQueenProblem 
{
	/**
     	* this method checks whether solution exists or not
     	* @param N dimension of matrix
     	* @return true if solution exist, false otherwise
     	*/
	public boolean nQueens(int N)
    	{
        	int row = 0; 
        	int[][] board = new int[N][N];
        
        	// initializing the board with 0 at all places
        	for(int i = 0; i < N; i++)
            		for(int j = 0; j < N; j++)
                		board[i][j] = 0;
        
        	boolean result = placeQueen(N, board, row);
        	return result;
    	}
    
   	/**
    	* checks whether queen can be placed at the given position on the board( board[row][column] ) or not
    	* @param board
     	* @param row
     	* @param column
     	* @param N dimension of matrix
     	* @return true if queen can be placed at specified position, false otherwise
     	*/
	private boolean canPlaceQueen(int[][] board, int row, int column, int N)
    	{
        	int i, j;
        
        	//checks if any queen exists in the same column
        	for(i = 0; i < row; i++) 
        	{
            		if(board[i][column] == 1)
                		return false;
        	}
        
        	//checks if any queen exists in the upper left diagonal
        	for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
        	{
            		if (board[i][j] == 1)
                		return false;
        	}
        
        	//checks if any queen exists in the upper right diagonal
        	for (i = row, j = column; i >= 0 && j < N; i--, j++)
        	{
            		if (board[i][j] == 1)
                		return false;
        	}            
       		return true; //queen can be placed at the specified position
    	}
    
    	/**
     	* places the queens on the board at positions where they can be placed, if possible
     	* @param N dimension of matrix
     	* @param board
     	* @param row
     	* @return
     	*/
    	private boolean placeQueen(int N, int[][] board, int row)
    	{
        	boolean placed = false;
        
        	for(int column = 0; column < N; column++)
        	{
            		placed = canPlaceQueen(board, row, column, N);
            
            		if(placed)
            		{
                		board[row][column] = 1; //placing the queen
                		row++;
                
                		if(row == N) //all queens have been placed
                		{
                    			placed = true;
                    			break;
                		}
                
                		if(!placeQueen(N, board, row))
                		{
                    			row--;
                    			board[row][column] = 0; //removing the queen in order to backtrack
                    			placed = false;
                		}
                		else
                    			break;
            		}
        	}
        	return placed;
    }
}
