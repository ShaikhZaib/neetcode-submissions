class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int n = s1.length();
        int m = s2.length();

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(int i = 0; i < n; i++){
            s1Count[s1.charAt(i) - 'a']++; 
            s2Count[s2.charAt(i) - 'a']++; 
        }

        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(s1Count[i] == s2Count[i]){
                matches++;
            }
        }

        int l = 0;
        for(int r = n; r < m; r++){
            if(matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if(s1Count[index] == s2Count[index]){
                matches++;
            } else if(s1Count[index] + 1 == s2Count[index]){
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if(s1Count[index] == s2Count[index]){
                matches++;
            } else if(s1Count[index] - 1 == s2Count[index]){
                matches--;
            }

            l++;
        }

        return matches == 26;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
