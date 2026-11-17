class Solution 
{
    public int hammingWeight(int n) 
    {
        // Count of set bits (1s).
        int count = 0;

        while (n != 0)
        {
            // Check if the last bit is 1.
            count += (n & 1);

            // Remove the last bit.
            n = n >> 1;
        }    

        return count;
    }
    // Time Complexity -> O(1)
    // Space Complexity -> O(1)
}