class Solution 
{
    public boolean canJump(int[] nums) 
    {
        // Start by assuming the last index
        // is the position we must reach.
        int goal = nums.length - 1;

        // Move backwards through the array.
        for (int i = nums.length - 2; i >= 0; i--)
        {
            // If from index i we can reach 
            // the current goal positon,
            // then i becomes the new goal.
            if (i + nums[i] >= goal) goal = i;
        }

        // If the goal eventually moves all the way
        // back to index 0, then we can reach the end.
        return goal == 0;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}