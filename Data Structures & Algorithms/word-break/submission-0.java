class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        // Let n represent the length of the string.
        int n = s.length();

        // dp[i] means:
        // can the substring starting at index i be broken into
        // valid dictionary words?
        boolean[] dp = new boolean[n + 1];

        // Base case:
        // An empty string can always be segmented successfully.
        dp[n] = true;

        // Process from right to left because dp[i]
        // depends on future stated dp[i + word.length()]
        for (int i = n - 1; i >= 0; i--)
        {
            // Try every word in the dictionary
            for (String word : wordDict)
            {
                // Check if the word fits inside the ramaining string.
                if (i + word.length() <= n)
                {
                    // Check if the current position starts with this word.
                    if (s.startsWith(word, i))
                    {
                        // If the word matches,
                        // check whether the ramaining suffix can be segmented.
                        dp[i] = dp[i + word.length()];

                        // If we've already found a valid segmentation,
                        // no need to continue checking other words.
                        if (dp[i]) break;
                    } 
                }
            }
        }   
        // dp[0] tells us whether the entire string can be segmented.
        return dp[0];
    }
    // Time Complexity -> O(n . m . k)
    // Space Complexity -> O(n)
}
