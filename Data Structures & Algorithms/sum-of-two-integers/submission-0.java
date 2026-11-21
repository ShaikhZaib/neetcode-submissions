class Solution 
{
    public int getSum(int a, int b) 
    {
        // Continue until there is no carry left.
        while (b != 0)
        {
            // Compute carry bits.
            int carry = (a & b) << 1;

            // Add without carrying.
            a ^= b;

            // Process carry in the next iteration.
            b = carry;
        }    

        return a;
    }
    // Time Complexity -> O(1)
    // Space Complexity -> O(1)
}