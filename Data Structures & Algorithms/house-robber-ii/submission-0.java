class Solution 
{
    public int rob(int[] nums) 
    {
        // Edge case: if there's only one house, rob it directly.
        if (nums.length == 1) return nums[0];
 
        // Case 1: Rob houses from index 1 to end (skip the first house).
        int case1 = robLinear(nums, 1, nums.length);

        // Case 2: Rob houses from index 0 to second-last (skip the last house).
        int case2 = robLinear(nums, 0, nums.length - 1);

        // Return the maximum of both cases.
        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end)
    {
        // prev1: max profit up to previous house.
        int prev1 = 0;

        // prev2: max profit up to house before previous.
        int prev2 = 0;

        for(int i = start; i < end; i++)
        {
            // Decide: rob current house (prev2 + num) or skip it (prev1).
            int current = Math.max(prev2 + nums[i], prev1);

            // Shifit valuse forward for next iteration.
            prev2 = prev1;
            prev1 = current;
        }

        // Return prev1.
        return prev1;
    }   
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
