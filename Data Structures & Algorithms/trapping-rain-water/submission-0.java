class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;

        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }

        return res;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
