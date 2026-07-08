class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int res = 0;

        while(left < right){
            int leftBar = heights[left];
            int rightBar = heights[right];
            int area = Math.min(leftBar, rightBar) * (right - left);
            res = Math.max(res, area);

            if(leftBar <= rightBar){
                left++;
            } else{
                right--;
            }
        }

        return res; 
    }

    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
