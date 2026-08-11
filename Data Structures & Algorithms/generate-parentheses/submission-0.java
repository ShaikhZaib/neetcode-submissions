class Solution {
    public List<String> generateParenthesis(int n) 
    {
        // Initialize res list and char array
        List<String> res = new ArrayList<>();
        char[] arr = new char[2 * n];

        // Call backtrack
        backtrack(res, arr, n, 0, 0, 0);

        // Return res
        return res;
    }

    private void backtrack(List<String> res, char[] arr, int n, int pos, int open, int close)
    {
        // Handle base case
        if (pos == 2 * n)
        {
            res.add(new String(arr));
            return;
        }

        // Add open parenthesis if valid and backtrack
        if (open < n)
        {
            arr[pos] = '(';
            backtrack(res, arr, n, pos + 1, open + 1, close);
        }

        // Add closing parenthesis if valid and backtrack
        if (close < open)
        {
            arr[pos] = ')';
            backtrack(res, arr, n, pos + 1, open, close + 1);
        }
    }
    // Time Complexity -> O(4 raise to n / root n)
    // Space Complexity -> O(n)
}
