class Solution 
{
    public int findTargetSumWays(int[] nums, int target) 
    {
        // Key = current sum
        // Value = number of ways to reach that sum
        Map<Integer, Integer> dp = new HashMap<>();
    
        // Base case:
        // There is one way to have a sum of 0
        // before processing any numbers.
        dp.put(0, 1);
    
        // Process each number one by one.
        for (int num : nums)
        {
            // Stores results for the current number.
            Map<Integer, Integer> nextDp = new HashMap<>();
    
            // Explore every sum we've built so far.
            for (Map.Entry<Integer, Integer> entry : dp.entrySet())
            {
                // currentSum = current sum's key
                // ways = current sum's value
                int currentSum = entry.getKey();
                int ways = entry.getValue();

                // Choose '+num'
                nextDp.put(currentSum + num, nextDp.getOrDefault(currentSum + num, 0) + ways);

                // Choose '-num'
                nextDp.put(currentSum - num, nextDp.getOrDefault(currentSum - num, 0) + ways);
            }

            // Move to the next state.
            dp = nextDp;
        }    
        // Return the number of ways to reach the target.  
        return dp.getOrDefault(target, 0);
    }
    // Time Complexity -> O(n . s)
    // Space Complexity -> O(s)
}
