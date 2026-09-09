class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        // Run a loop from third last elemnt to the first one.
        for (int i = cost.length - 3; i >= 0; i--)
        {
            // For each stair add the minimum of the next two possible moves.
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        // Return the minimum of first two stairs cost.
        return Math.min(cost[0], cost[1]);
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
