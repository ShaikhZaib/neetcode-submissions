class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++){
            if(i % k == 0){
                leftMax[i] = nums[i];
            } else{
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            }

            int j = n - 1 - i;
            if((j + 1) % k == 0){
                rightMax[j] = nums[j];
            } else{
                rightMax[j] = Math.max(rightMax[j + 1], nums[j]);
            }
        }

        int[] output = new int[n - k + 1];
        for(int i = 0; i <= n - k; i++){
            output[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
        }

        return output;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(n)
}
