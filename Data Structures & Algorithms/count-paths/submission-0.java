class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        // dp[j] represents the number of paths from the 
        // current cell to the bottom-right corner.
        int[] dp = new int[n];

        // Intialize the last row with 1s.
        // In the last row, there is only one way to reach 
        // the destination: keep moving right.
        Arrays.fill(dp, 1);

        // Start from the second-last row and move upward.
        for (int i = m - 2; i >= 0; i--)
        {
            // Start from the second-last column nad move left.
            for (int j = n - 2; j >= 0; j--)
            {
                // Number of paths from current cell =
                // path from cell below + paths from cell to the right.
                dp[j] = dp[j] + dp[j + 1];
            }
        }

        // Top-left cell answer.
        return dp[0];
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(n)
}
