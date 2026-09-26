class Solution 
{
    // Four possible directions:
    // Up, Down, Left, Right.
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // Memoization tablel
    // dp[r][c] stores the longest increasing path
    // starting from cell (r, c).
    int[][] dp;

    private int dfs (int[][] matrix, int r, int c, int prevValue)
    {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // Invalid cases:
        // 1. Out of bounds
        // 2. Not strictly increasing
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || matrix[r][c] <= prevValue)
        {
            return 0;
        }

        // If already computed, return cached result
        if (dp[r][c] != -1)
        {
            return dp[r][c];
        }

        // Minimum pathe length is 1
        int longestPath = 1;

        // Try moving in all 4 directions
        for (int[] dir : directions)
        {
            longestPath = Math.max(longestPath, 1 + dfs(matrix, r + dir[0], c + dir[1], matrix[r][c]));
        }

        // Cache the result
        dp[r][c] = longestPath;

        // Return the result
        return longestPath;
    }
    public int longestIncreasingPath(int[][] matrix) 
    {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // Stores answer for each table.
        dp = new int[ROWS][COLS];

        // Intialize memization table.
        for (int r = 0; r < ROWS; r++)
        {
            Arrays.fill(dp[r], -1);
        }

        int answer = 0;

        // Start DFS from every cell
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                answer = Math.max(answer, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }

        // Return the answer
        return answer;
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
