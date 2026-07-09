class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int res = 0;

        for(int right = 0; right < s.length(); right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(m)
}
