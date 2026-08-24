class Solution {
    // Create an directional array.
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        // Initialize grid dimensions and boolean matrices to track each ocean.
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
  
        // Run dfs from top and bottom row 
        for (int c = 0; c < COLS; c++)
        {
            // Top row
            dfs(heights, pac, 0, c);

            // Bottom row
            dfs(heights, atl, ROWS - 1, c);
        }

        // Run dfs from left right column
        for (int r = 0; r < ROWS; r++)
        {
            // Left column
            dfs(heights, pac, r, 0);

            // Right column
            dfs(heights, atl, r, COLS - 1);
        }

        // Intialize res and add the cell marked in both matrices   
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (pac[r][c] && atl[r][c])
                {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        // Return res.
        return res;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c)
    {
        // Mark the cell
        ocean[r][c] = true;

        // Run dfs on every neighbor
        for (int[] dir : directions)
        {
            // Calculate dimensions
            int nr = r + dir[0];
            int nc = c + dir[1];

            // Handle boundry, visited and height check
            if 
            (
                nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]
            )
            {
                dfs(heights, ocean, nr, nc);
            }
        }
    }
    // Time Complexity -> O(m.n)
    // Space Complexity -> O(m.n)
}
