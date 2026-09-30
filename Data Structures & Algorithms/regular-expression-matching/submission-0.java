class Solution 
{
    // Memoization table
    // dp[i][j] stores whether 
    // s[i:] can match p[j:]
    private Boolean[][] dp;

    public boolean isMatch(String s, String p) 
    {
        int m = s.length();
        int n = p.length();

        // Create memo table for all possible states.
        dp = new Boolean[m + 1][n + 1];

        // Start matching from the beginning
        // of both string and pattern.
        return dfs(0, 0, s, p, m, n);
    }

    private boolean dfs(int i, int j, String s, String p, int m, int n)
    {
        // Base Case:
        // Pattern is fully consumed.
        // Match succeeds only if string 
        // is also fully consumed.
        if (j == n) return i == m;

        // Return chached answer if we've 
        // already solveed this state.
        if (dp[i][j] != null) return dp[i][j];

        // Chech whether current characters matck.
        //
        // Match is true if:
        // 1. String still has characters.
        // 2. Characters are equal OR pattern is '.'
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // Check if next pattern character is "*"
        if (j + 1 < n && p.charAt(j + 1) == '*')
        {
            // Two possibilities:
            // 
            // 1. Skip "x" completely
            //    Example:
            //    s = 'aaa'
            //    p = 'a*'
            //
            //    Move pattern forward by 2:
            //    dfs(i, j + 2)
            // 
            // 2. Use one matching character 
            //    from the string and stay at
            //    the same pattern position.
            //
            //    stay at j because '*'
            //    may consume more characters. 
            dp[i][j] = dfs(i, j + 2, s, p, m, n)
                       ||
                       (match && dfs(i + 1, j, s, p, m, n));
        }
        else
        {
            // Normal matching.
            //
            // Current characters must match,
            // then move both pointers forward.
            dp[i][j] = match && dfs(i + 1, j + 1, s, p, m, n);
        }

        return dp[i][j];
    }
    // Time Complexity -> O(m . n)
    // Space Complexity -> O(m . n)
}
