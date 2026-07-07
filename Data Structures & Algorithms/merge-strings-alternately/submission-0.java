class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int minLength = Math.min(n, m);
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < minLength; i++){
            if(i < n) res.append(word1.charAt(i));
            if(i < m) res.append(word2.charAt(i));
        }

        res.append(word1.substring(minLength));
        res.append(word2.substring(minLength));

        return res.toString();
    }
    // Time Complexity -> O(m + n)
    // Space Complexity -> O(m + n)
}