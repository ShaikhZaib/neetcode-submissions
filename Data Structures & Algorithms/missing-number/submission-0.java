class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int n = nums.length;

        // Start with n because indices go from 0 to n - 1,
        // but numbers should be from 0 to n.
        int xorr = n;

        for (int i = 0; i < n; i++)
        {
            // Cancel matching index and value pairs.
            xorr ^= i ^ nums[i];
        }    

        // The missing number remains.
        return xorr;
    }
    // Time Complexity -> O(1)
    // Space Complexity -> O(1)
}