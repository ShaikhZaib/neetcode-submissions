class Solution {
    public List<String> letterCombinations(String digits) 
    {
        // Initialize the res list and digitToChar
        List<String> res = new ArrayList<>();
        String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder currStr = new StringBuilder(digits.length());

        // Check if the digits is empty 
        if (digits.isEmpty()) return res;

        // Call backtrack
        backtrack(res, digitToChar, digits, 0, currStr);

        // Return res
        return res;
    }

    private void backtrack(List<String> res, String[] digitToChar, String digits, int i, StringBuilder currStr)
    {
        // Handle base case
        if (currStr.length() == digits.length())
        {
            res.add(currStr.toString());
            return;
        }

        // Store the chars from digitToChar in chars string
        String chars = digitToChar[digits.charAt(i) - '0'];

        // Loop through chars and backtrack
        for (char c : chars.toCharArray())
        {
            currStr.append(c);
            backtrack(res, digitToChar, digits, i + 1, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
    // Time Complexity -> O(n * 4 raise to n)
    // Space Complexity -> O(n) auxilary space
    //                  -> O(n * 4 raise to n)
}
