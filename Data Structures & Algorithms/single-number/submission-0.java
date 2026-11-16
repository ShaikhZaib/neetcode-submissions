class Solution 
{
    public int singleNumber(int[] nums) 
    {
        // Store the unique number.
        int res = 0;

        for (int num : nums)
        {
            // XOR current number with result.
            res ^= num;
        }   

        // All duplicate number cancel out.
        // only the single number remains.
        return res;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}