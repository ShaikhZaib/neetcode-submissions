class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0) res = num;
            
            count += (num == res) ? 1 : -1; 
        }

        return res;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}