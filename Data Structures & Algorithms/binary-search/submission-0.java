class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target > nums[mid]){
                l = mid + 1;
            } else if(target < nums[mid]){
                r = mid - 1;
            } else{
                return mid;
            }
        }

        return -1;
    }
    // Time Complexity -> O(log n)
    // Space Complexity -> O(1)
}
