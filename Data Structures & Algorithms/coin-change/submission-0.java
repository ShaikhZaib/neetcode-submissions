class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
      // dp[i] will store the minimum number of coins needed to make amount i.
      int[] dp = new int[amount + 1];

      // Intialize all values to "infinity" (a very large number),
      // meaning we don't yet know how to make those amounts.
      Arrays.fill(dp, Integer.MAX_VALUE / 2);

      // Base case: 0 coins are needed to make amount 0.
      dp[0] = 0;

      // Loop through each coin denomination.
      for (int coin : coins)
      {
        // For each amount starting from the coin value up to the target amount.
        for (int i = coin; i <= amount; i++)
        {
            // Transition: either keep the current besst solution for dp[i],
            // or use this coun and add 1 to the solution for (i - coin).
            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }  

      // If dp[amount] is still "infinity", it means we couldn't form the amount
      // Return -1 in that case, otherwise returns the minimum number of coins
      return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
    // Time Complexity -> O(n . t)
    // Space Complexity -> O(t)
}
