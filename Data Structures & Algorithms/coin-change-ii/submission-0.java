class Solution 
{
    public int change(int amount, int[] coins) 
    {
        // dp[i] represents the number of ways
        // to make amout i.
        int[] dp = new int[amount + 1];

        // Base case:
        // There is exactly one way to make amount 0:
        // choose nothing.
        dp[0] = 1;

        // Process each coin one at a time.
        for (int coin : coins)
        {
            // Try using the current coint to build
            // all possible amounts.
            for (int currAmount = coin; currAmount <= amount; currAmount++)
            {
                // Ways to make currAmount:
                // Exiting ways
                // +
                // Ways to make (currAmount - coin)
                dp[currAmount] += dp[currAmount - coin];
            }
        }
        // Number of ways to make the target amount.    
        return dp[amount];
    }
    // Time Complexity -> O(n . a)
    // Space Complexity -> O(a)
}
