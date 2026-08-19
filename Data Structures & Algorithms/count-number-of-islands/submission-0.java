class Solution 
{
    // Make directios array
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) 
    {
        // Intialize ROWS, COLS, and islands
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands = 0;

        // Loop through every cell in grid and call dfs if it's an island
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (grid[r][c] == '1')
                {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }

        // Return islands
        return islands;
    }

    private void dfs(char[][] grid, int r, int c)
    {
        // Handle boundry check and water check
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
        {
            return;
        }


        // Mark the island as water
        grid[r][c] = '0';

        // Call dfs in every direction
        for (int[] dir : directions)
        {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
