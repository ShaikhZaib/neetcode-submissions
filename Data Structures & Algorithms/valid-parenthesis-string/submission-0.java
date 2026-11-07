class Solution 
{
    public boolean checkValidString(String s) 
    {
        // Minimum possible number of 
        // unmatched '(' characters.
        int leftMin = 0;

        // Maximum possible number of 
        // unmatched '(' characters.
        int leftMax = 0;

        for (char c : s.toCharArray())
        {
            // Normal opening bracket.
            if (c == '(')
            {
                // Definitely increases both.
                leftMin++;
                leftMax++;
            }

            // Normal closing bracket.
            else if (c == ')')
            {
                // Must consume one opening bracket.
                leftMin--;
                leftMax--;
            }

            // Wildcard '*'
            else
            {
                // Best case:
                // treat '*' as ')'
                leftMin--;

                // Worst case:
                // treat '*' as '('
                leftMax++;
            }

            // Too many ')' encountered.
            // Even treating every '*' as '('
            // isn't enough to balance.
            if (leftMax < 0) return false;

            // Minimum open brackets 
            // can never go below 0.
            if (leftMin < 0) leftMin = 0;
        }  
        // Valid only if 0 open brackets
        // is still possible.
        return leftMin == 0;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}