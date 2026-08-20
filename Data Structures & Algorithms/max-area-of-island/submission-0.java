class Solution 
{
    // Intialize direction array
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) 
    {
        // Intialize ROWS, COLS and area
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int area = 0;

        // Loop through each cell and calculate area
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (grid[r][c] == 1)
                {
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }

        // Return area    
        return area;
    }

    private int dfs(int[][] grid, int r, int c)
    {
        // Handle boundry check and water check
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
        {
            return 0;
        }

        // Mark the island and intialize res(current islnd area)
        grid[r][c] = 0;
        int res = 1;

        // Run dfs on every in direction
        for (int[] dir : directions)
        {
            res += dfs(grid, r + dir[0], c + dir[1]);
        }

        // Return res
        return res;
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
