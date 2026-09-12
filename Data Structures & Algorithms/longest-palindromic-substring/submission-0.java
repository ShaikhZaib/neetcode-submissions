class Solution {
    // Helper function: expand around center(returns palindrome length).
    private int expandAroundCenter(String s, int l, int r)
    {
        // Boundry check and character check.
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
        }

        // Return the length of palindrome.
        return r - l - 1;
    } 

    public String longestPalindrome(String s) 
    {
        // Handle null and length check.
        if (s == null || s.length() == 0) return "";

        // Intialize start(start index of longest palindrome).
        int start = 0;

        // Intialize end(end index of longest palindrome).
        int end = 0;

        // Run palindrome check on the string
        for (int i = 0; i < s.length(); i++)
        {
            // Check for oddLen.
            int oddLen = expandAroundCenter(s, i, i);

            // Check for evenLen.
            int evenLen = expandAroundCenter(s, i, i + 1);

            // Get the max of the two.
            int maxLen = Math.max(oddLen, evenLen);

            // if maxLen is bigger than current update end and start.
            if (maxLen > end - start)
            {
                start = i - (maxLen - 1) / 2;
                end = i + (maxLen / 2);
            }
        }

        // return longest palindrome.
        return s.substring(start, end + 1);
    }
    // Time Complexity -> O (n square)
    // Space Complexity -> O(1) auxilary space
}
