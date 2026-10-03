class Solution 
{
    public int jump(int[] nums) 
    {
        // Farthest position we can currently reach.
        int maxReach = 0;

        // End of the current jump range.
        int currentEnd = 0;

        // Number of jumps taken.
        int jump = 0;

        // Ne need to precess the last index because 
        // once we reach it, we're done.
        for (int i = 0; i < nums.length - 1; i++)
        {
            // Update the farthest position reachable 
            // from any index seen so far.
            maxReach = Math.max(maxReach, i + nums[i]);

            // IF we're reached the end of the 
            // current jump rangs...
            if (i == currentEnd)
            {
                // We must make another jump.
                jump++;

                // The new range ends at the 
                // farthest position we can reach.
                currentEnd = maxReach;
            }
        }
        // Return number of jumps taken.
        return jump;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}