class Solution 
{
    public int reverse(int x) 
    {
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;

        int result = 0;

        while (x != 0)
        {
            // Extract the last digit.
            int digit = x % 10;

            // Remove the last digit.
            x /= 10;

            // Check positive overflow.
            if (result > MAX / 10 || (result == MAX / 10) && digit > MAX % 10) return 0;

            // Check negative overflow.
            if (result < MIN / 10 || (result == MIN / 10) && digit < MIN % 10) return 0;

            // Append digit to reversed number.
            result = result * 10 + digit;
        }    

        return result;
    }
    // Time Complexity -> O(log10(x))
    // Space Complexity -> O(1)
}