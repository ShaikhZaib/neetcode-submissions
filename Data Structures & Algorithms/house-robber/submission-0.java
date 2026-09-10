class Solution 
{
    public int rob(int[] nums) 
    {
        // Intialize prevTwo = max loot up to two houses ago.
        int prevTwo = 0;
        
        // Intialize prevOne = max loot up to previous house.
        int prevOne = 0;

        // Iterate over all the num in nums.
        for (int num : nums)
        {
            // Decide: rob this house (money + prevTwo) or skip (prevOne).
            int best = Math.max(num + prevTwo, prevOne);

            // Shift window forward.
            prevTwo = prevOne;
            prevOne = best;
        }

        // Return the prevOne.   
        return prevOne;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
