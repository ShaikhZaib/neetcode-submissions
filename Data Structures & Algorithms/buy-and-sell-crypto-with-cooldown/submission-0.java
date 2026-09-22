class Solution 
{
    public int maxProfit(int[] prices) 
    {
        // nextBuy = profit for the next day when we are allowed to BUY.
        int nextBuy = 0;

        // nextSell = profit for the next day when we are holding a stock
        // and must decide whether to SELL or HOLD.
        int nextSell = 0;

        // buyAfterCooldown = profit for two days ahead in BUY state.
        // Needed because after selling there is a 1-day cooldown.
        int buyAfterCooldown = 0;

        // Process days from right to left.
        for (int i = prices.length - 1; i >= 0; i--)
        {
            // BUY state:
            // Option 1: Buy stock today (-price)
            // Option 2: Skip today
            int currentBuy = Math.max(nextSell - prices[i], nextBuy);

            // SELL state:
            // Option 1: Sell today (+price)
            //           then cooldown for one day
            // Option 2: Keep holding.
            int currentSell = Math.max(buyAfterCooldown + prices[i], nextSell);

            // Shift DP states for the next iteration 
            buyAfterCooldown = nextBuy;
            nextBuy = currentBuy;
            nextSell = currentSell;
        }
        // We start on day 0 without owning a stock,
        // meaning we're intially in the BUY state.
        return nextBuy;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
