class Solution 
{
    public int[] countBits(int n) 
    {
       // dp[i] = number of 1 bits in i
       int[] dp = new int[n + 1];

       // Current power of 2.
       int offset = 1;

       for (int i = 1; i <= n; i++)
       {
        // Found a new power of 2.
        if (offset * 2 == i) offset = i;

        // Current number = offset + remainder
        // Example:
        // 13 = 8 + 5
        //
        // bits(13) = 1 + bits(5);
        dp[i] = 1 + dp[i - offset];
       }     

       return dp;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1) (Auxilary space)
    //                     O(n) (Output space)
}