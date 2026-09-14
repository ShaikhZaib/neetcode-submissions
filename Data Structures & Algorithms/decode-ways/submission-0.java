class Solution 
{
    public int numDecodings(String s) 
    {
        // Handle the edge cases(null and empty string).
        if (s == null || s.length() == 0) return 0;

        // Intilaize next(Base case: emty string -> 1 way).
        int next = 1;

        // Intialize next2(Intially no ways beyond the end).
        int next2 = 0;

        // Intialize current(dp[i] for the current index).
        int current;

        // Treverse from right to left.
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == '0')
            {
                // '0' cannot be decoded alone.
                current = 0;
            }
            else
            {
                // Single-digit decode always possible.
                current = next;

                // Chech if two-digit decode is valid(10-26)
                if (i + 1 < s.length())
                {
                    int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                    if (twoDigit >= 10 && twoDigit < 27)
                    {
                        current += next2;
                    }
                }
            }

            // Shift window forward.
            next2 = next;
            next = current;
        }    

        // Return next.
        return next;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
