class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int p : piles){
            if(p > r) r = p;
        }
        int res = r;

        while(l <= r){
            int k = l + (r - l) / 2;
            
            long totalTime = 0;
            for(int p : piles){
                totalTime += (p + k - 1) / k;
            }

            if(totalTime <= h){
                res = k;
                r = k - 1;
            } else{
                l = k + 1;
            }
        }

        return res;
    }
    // Time Complexity -> O(n * log m)
    // Space Complexity -> O(1)
}
