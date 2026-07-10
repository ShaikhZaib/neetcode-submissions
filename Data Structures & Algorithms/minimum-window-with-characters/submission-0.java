class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int[] charCounts = new int[128];
        for(char c : t.toCharArray()){
            charCounts[c]++;
        }

        int itemsNeeded = t.length();
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int r = 0; r < n; r++){
            char c = s.charAt(r);
            
            if(charCounts[c] > 0){
                itemsNeeded--;
            }
            charCounts[c]--;

            while(itemsNeeded == 0){
                if(r - l + 1 < minLength){
                    minLength = r - l + 1;
                    startIndex = l;
                }

                char leftChar = s.charAt(l);
                charCounts[leftChar]++;
                if(charCounts[leftChar] > 0){
                    itemsNeeded++;
                }

                l++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(startIndex, startIndex + minLength);
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
