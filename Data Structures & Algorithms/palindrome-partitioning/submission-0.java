class Solution {
    public List<List<String>> partition(String s) 
    {
        // Initializing the result and part list
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        // Call dfs
        dfs(res, part, s, 0, 0);

        // Return res
        return res;
    }

    private void dfs(List<List<String>> res, List<String> part, String s, int i, int j)
    {
        // Handle base case
        if (j >= s.length())
        {
            if (i == j)
            {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        // Check if the string is palindrome 
        if (isPalindrome(s, i, j))
        {
            part.add(s.substring(i, j + 1));
            dfs(res, part, s, j + 1, j + 1);
            part.remove(part.size() - 1);
        }

        // Call the dfs without moving start index
        dfs(res, part, s, i, j + 1);
    }

    private boolean isPalindrome(String s, int l, int r)
    {
        // Check if the string is palindrome
        while (l < r)
        {
            if (s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    // Time Complexity -> O(n * 2 raise to n)
    // Space Complexity -> O(n) auxilary space 
    //                  -> O(n * 2 raise to n)
}
