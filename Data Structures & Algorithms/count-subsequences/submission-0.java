class Solution 
{
    public int numDistinct(String s, String t) 
    {
        int m = s.length();
        int n = t.length();

        // dp[i][j] = 
        // number of ways to build t[j:]
        // using s[i:]
        int[][] dp = new int[m + 1][n + 1];

        // Base case:
        // Empty target can always be formed
        // in exactly one way.
        for (int i = 0; i <= m; i++)
        {
            dp[i][n] = 1;
        }

        // Build answer from bottom-right
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                // Option 1:
                // Skip the current character in s
                dp[i][j] = dp[i + 1][j];
                
                // Option 2:
                // Use current character is it matches
                if (s.charAt(i) == t.charAt(j))
                {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }    
        // return the answer(top-left)
        return dp[0][0];
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
