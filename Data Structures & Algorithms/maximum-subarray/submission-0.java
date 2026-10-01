class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        // maxSum stores the best subarray sum found so far.
        int maxSum = nums[0];

        // currSum stores the maximum subarray sum
        // ending at the current index.
        int currSum = nums[0];

        // Start from the second element because
        // we've already used nums[0] to intialize.
        for (int i = 1; i < nums.length; i++)
        {
            // Two Choices:
            //
            // 1. Start a new subarray from nums[i]
            // 2. Extend the previous subarray
            //
            // Take whichever gives the larger sum.
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Update the overall best answer.
            maxSum = Math.max(maxSum, currSum);
        }

        // Return the largest subarray sum.
        return maxSum;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}