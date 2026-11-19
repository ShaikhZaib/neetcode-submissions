class Solution 
{
    public int reverseBits(int n) 
    {
        int result = 0;

        // Process all 32 bits.
        for (int i = 0; i < 32; i++)
        {
            // Extract the i-th bit.
            int bit = (n >> i) & 1;

            // Place it in its reversed position.
            result |= (bit << (31 - i));
        }    

        return result;
    }
    // Time Complexity -> O(1)
    // Space Complexity -> O(1)
}