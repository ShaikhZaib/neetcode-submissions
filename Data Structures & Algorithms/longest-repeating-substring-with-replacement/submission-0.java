class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charCounts = new int[26];
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;

        for(int right = 0; right < n; right++){
            char c = s.charAt(right);

            charCounts[c - 'A']++;
            maxFreq = Math.max(maxFreq, charCounts[c - 'A']);

            if((right - left + 1) - maxFreq > k){
                char leftChar = s.charAt(left);
                charCounts[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
