class Solution {
    // Intialize the direction array.
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
 
    public void solve(char[][] board) 
    {
        // Intialze ROWS and COLS.
        int ROWS = board.length;
        int COLS = board[0].length;

        // Scan left and right border and capture all 0 
        for (int r = 0; r < ROWS; r++)
        {
            // Left border
            if (board[r][0] == 'O')
            {
                capture(board, r, 0);
            }

            // Right border
            if (board[r][COLS - 1] == 'O')
            {
                capture(board, r, COLS - 1);
            }
        }

        // Scan top and bottom border and caprute all 0
        for (int c = 0; c < COLS; c++)
        {
            // Top border
            if (board[0][c] == 'O')
            {
                capture(board, 0, c);
            }

            // Bottom border
            if (board[ROWS - 1][c] == 'O')
            {
                capture(board, ROWS - 1, c);
            }
        }

        // Loop through all the cell and convert surrounded and safe region    
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (board[r][c] == 'O')
                {
                    board[r][c] = 'X';
                }
                else if (board[r][c] == 'T')
                {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int r, int c)
    {
        // Handle boundry and element check
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O')
        {
            return;
        }

        // Mark the safe element
        board[r][c] = 'T';

        // Run capture on it's neighbor
        for (int[] dir : directions)
        {
            capture(board, r + dir[0], c + dir[1]);
        }
    }
    // Time Complexity -> O(m.n)
    // Space Complexity -> O(m.n)
}
