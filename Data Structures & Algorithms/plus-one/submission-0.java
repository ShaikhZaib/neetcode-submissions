class Solution 
{
    public int[] plusOne(int[] digits) 
    {
        int n = digits.length;

        // Process digits from right to left.
        for (int i = n - 1; i >= 0; i--)
        {
            // No carry needed.
            if (digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }

            // 9 becomes 0 and carry moves left.
            digits[i] = 0;
        }

        // If we reach here, all digits were 9.
        //
        // Example: 999 + 1 = 1000
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(n)
}
