class Solution 
{
    public int maxProduct(int[] nums) 
    {
        // Track the maximum product ending at the current position.
        int maxProd = nums[0];

        // Track the minimum product ending at the currnet position.
        // (important because a negative number can flip signs)
        int minProd = nums[0];

        // Track the overall maximum product found so far.
        int result = nums[0];

        // Itarate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++)
        {
            // Temporarily store the previous maxProd before updating 
            int temp = maxProd;

            // Update maxProd:
            // Either take the current numver alone,
            // or multiply it with the previous maxProd,
            // or multiply it with the previous minProd (if negative flips to positive).
            maxProd = Math.max(nums[i], Math.max(nums[i] * maxProd, nums[i] * minProd));

            // Update minProd: 
            // Either take the current number alone,
            // or multiply it with the previous maxProd (stored in temp),
            // or multiply it with the previous minProd.
            minProd = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minProd));

            // Update the globla result with the best maxProd so far.
            result = Math.max(result, maxProd);
        }   

        // Return the maximum product subarray found.
        return result;
    }
    // Time Complexity -> O(n) -- single pass through the array.
    // Space Complexity -> O(1) -- constant extra variables.
}
