class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = 
        // Minimum operations needed to convert
        // word1[i:] into word2[j:].
        int[][] dp = new int[m + 1][n + 1];

        // Base Case 1:
        // word1 is exhausted.
        // We must insert all remaining characters of word2.
        for (int j = 0; j <= n; j++)
        {
            dp[m][j] = n - j;
        }

        // Base Case 2:
        // word2 is exhausted.
        // We must delete all remaining characters of word1.
        for (int i = 0; i <= m; i++)
        {
            dp[i][n] = m - i;
        }

        // Build solution from bottom-right to top-left.
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                // Characters already match.
                // No operation needed.
                if (word1.charAt(i) == word2.charAt(j))
                {
                    dp[i][j] = dp[i + 1][j + 1];
                }
                else
                {
                    // Delete:
                    // Remove current char from word1.
                    int delete = dp[i + 1][j];

                    // Insert:
                    // Insert current char from word2.
                    int insert = dp[i][j + 1];

                    // Replace:
                    // Replace word1[i] with word2[j].
                    int replace = dp[i + 1][j + 1];

                    // Take the cheapest operation.
                    dp[i][j] = 1 + Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        // Convert entire word1 into entire word2.   
        return dp[0][0];
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
