class Solution {
    public void reverseString(char[] s) {
        int right = s.length - 1;

        for(int left = 0; left < right; left++){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
        }
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}