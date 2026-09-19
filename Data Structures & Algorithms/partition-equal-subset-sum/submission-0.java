class Solution 
{
    public boolean canPartition(int[] nums) 
    {
        // Calculate the total sum of all numbers.
        int totalSum = sum(nums);

        // If the total sum is odd,
        // it can never be split into two equal halves.
        if (totalSum % 2 != 0) return false;

        // If partitioning is possible,
        // each subset must sum to half of the total.
        int target = totalSum / 2;

        // dp[i] means:
        // Can we form a subset whose sum equals i?
        boolean[] dp = new boolean[target + 1];

        // Base case:
        // Sum 0 is always achievable by choosing nothing.
        dp[0] = true;

        // Process each number exactly once.
        for (int num : nums)
        {
            // Iterate backwards to prevent reusing
            // the same number multiple times.
            for (int currSum = target; currSum >= num; currSum--)
            {
                // Current sum is achievable if:
                // 1. It was already achievable, OR
                // 2. We can reach (currSum - num)
                //    and include the current number.
                dp[currSum] = dp[currSum] || dp[currSum - num];
            }
        }  

        // If target is achievable,
        // the array can be partitoned into two equal subsets. 
        return dp[target];
    }

    // Make the sum method.
    private int sum (int[] nums)
    {
        int total = 0;
        for (int num : nums)
        {
            total += num;
        }
        return total;
    }
    // Time Complexity -> O(n . target)
    // Space Complexity -> O(target)
}
