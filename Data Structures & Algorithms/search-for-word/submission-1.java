class Solution {
    // Make Rows, Cols, and visited array
    private int ROWS;
    private int COLS;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) 
    {
        // Initialize Rows, Cols and visited array
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        // Loop through Rows and Cols and call dfs
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (dfs(board, word, r, c, 0))
                {
                    return true;
                }
            }
        }

        // Return false    
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i)
    {
        // Handle base case
        if (i == word.length())
        {
            return true;
        }

        // Handle boundry and character check
        if 
        (
            r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            board[r][c] != word.charAt(i) || visited[r][c] 
        )
        {
            return false;
        }

        // Explore further in every direction
        visited[r][c] = true;
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      dfs(board, word, r - 1, c, i + 1) ||
                      dfs(board, word, r, c + 1, i + 1) ||
                      dfs(board, word, r, c - 1, i + 1);
  
        visited[r][c] = false;

        // Return res
        return res;
    }
    // Time Complexity -> O(m * 4 raise to n)
    // Space Complexity -> O(n)
}
