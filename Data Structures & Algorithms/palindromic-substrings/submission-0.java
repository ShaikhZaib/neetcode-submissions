class Solution 
{
    public int countSubstrings(String s) 
    {
        // Initialize totalCount(stores how many palindrome are there).
        int totalCount = 0;

        // For every character expand it around center and find palindromes.
        for (int i = 0, n = s.length(); i < n; i++)
        {
            // Add odd-length palindromes.
            totalCount += expandAroundCenter(s, i, i);

            // Add even-length palindromes.
            totalCount += expandAroundCenter(s, i, i + 1);
        }

        // Return totalCount of palindromes.
        return totalCount;
    }

    private int expandAroundCenter(String s, int l, int r)
    {
        // Intialize count(tracks all the palindrome for current part).
        int count = 0;

        // Increment count and expand untill theyr'e in a valid boundry and the string is palindrome.
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            count++;
            l--;
            r++;
        }

        // Return count.
        return count;
    }
    // Time Complexity -> O(n square)
    // Space Complexity -> O(1)
}
