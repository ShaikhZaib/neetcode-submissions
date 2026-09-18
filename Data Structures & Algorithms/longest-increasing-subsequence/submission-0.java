class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        // LIS[i] represents the length of the longest
        // increasing subsequence starting at index i.
        int[] LIS = new int[nums.length];

        // Every element by itself is a valid increasing 
        // Subsequence of length 1.   
        Arrays.fill(LIS, 1);

        // Track the overall longest increasing subsequence.
        int result = 1;

        // Process from right to left because LIS[i]
        // depends on LIS values to its right.
        for (int i = nums.length - 1; i >= 0; i--)
        {
            // Try extending nums[i] with every element
            // that comes after it.
            for (int j = i + 1; j < nums.length; j++)
            {
                // If nums[j] is larger, it can be part of an
                // increasing subsequence starting from nums[i].
                if (nums[j] > nums[i])
                {
                    // Either keep the current LIS length,
                    // or extend through nums[j].
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }

            // Update the global answer after calculating Lis[i].
            result = Math.max(result, LIS[i]);
        }  

        // Return the length of the longest increasing subsequence.    
        return result;
    }
    // Time Complexity -> O(n square)
    // Space Complexity -> O(n)
}
