class Solution 
{
    public boolean isInterleave(String s1, String s2, String s3) 
    {
        int m = s1.length();
        int n = s2.length();
        
        // If lengths don't add up,
        // interleaving is impossible.
        if (m + n != s3.length()) return false;

        // dp[i][j] means:
        // Can first (i + j) chars of s1 and first j chars of s2
        // form first (i + j) chars of s3?
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty strings can form empty string.
        dp[0][0] = true;

        // Fill first column.
        // We can only take characters from s1.
        for (int i = 1; i <= m; i++)
        {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill first row.
        // We can only take characters from s2.
        for (int j = 1; j <= n; j++)
        {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the rest of the table.
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // Current index in s3.
                int k = i + j - 1;

                // Option 1:
                // Take current character from s1.
                if (s1.charAt(i - 1) == s3.charAt(k) && dp[i - 1][j])
                {
                    dp[i][j] = true;
                }

                // Option 2:
                // Take current character from s2.
                if (s2.charAt(j - 1) == s3.charAt(k) && dp[i][j - 1])
                {
                    dp[i][j] = true;
                }
            }
        }    
        // Can entire s1 and s2 form entire s3?
        return dp[m][n];
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
