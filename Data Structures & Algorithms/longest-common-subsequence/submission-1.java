class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        // dp[i][j] represents the length of the Longest Common 
        // Subsequence between:
        // text1 starting from index i
        // text2 starting from index j
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Fill the DP table from bottom-right to top-left
        // because dp[i][j] depends on future states.
        for (int i = text1.length() - 1; i >= 0; i--)
        {
            for (int j = text2.length() - 1; j >= 0; j--)
            {
                // If the characters match, include this character
                // in the subsequence and move diagonally.
                if (text1.charAt(i) == text2.charAt(j))
                {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else 
                {
                    // Characters don't match.
                    // Try skiping a character from text1,
                    // or skipping a character from text2.
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }  

        // Top-left cell contains the LCS length
        // for the complete strings.       
        return dp[0][0];
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
