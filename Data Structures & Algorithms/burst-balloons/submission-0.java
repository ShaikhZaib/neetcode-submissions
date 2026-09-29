class Solution 
{
    public int maxCoins(int[] nums) 
    {
        int n = nums.length;

        // Add imaginary ballons with value 1
        // to both ends of the array.
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++)
        {
            newNums[i + 1] = nums[i];
        }

        // dp[l][r] stores the maximum coins obtainable
        // by bursting all balloons between l and r.
        int[][] dp = new int[n + 2][n + 2];

        // Intialize memo table
        for (int i = 0; i < dp.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        // solve for the entire range of real ballons     
        return dfs(newNums, 1, n, dp);
    }

    private int dfs(int[] nums, int l, int r, int[][] dp)
    {
        // No balloons left
        if (l > r) return 0;

        // Memoized answer
        if (dp[l][r] != -1) return dp[l][r];

        int maxCoins = 0;

        // Choose balloon i as the LAST balloon 
        // to burst in range [l, r]
        for (int i = l; i <= r; i++)
        {
            // Coins gained when i is burst last
            int currentCoins = nums[l - 1] * nums[i] * nums[r + 1];

            // Coins from left side
            int leftCoins = dfs(nums, l, i - 1, dp);

            // Coinss from right side
            int rightCoins = dfs(nums, i + 1, r, dp);

            maxCoins = Math.max(maxCoins, currentCoins + leftCoins + rightCoins);
        }

        return dp[l][r] = maxCoins;
    }
    // Time Complexity -> O(n cube)
    // Space Complexity -> O(n square)
}
