class Solution 
{
    public boolean mergeTriplets(int[][] triplets, int[] target) 
    {
        // Have we found a valid triplet that contributes 
        // target[0]?
        boolean first = false;

        // Have we found a valid triplet that contributes 
        // target[1]?
        boolean second = false;

        // Have we found a valid triplet that contributes 
        // target[2]?
        boolean third = false;

        // Examine every triplet.
        for (int[] triplet : triplets)
        {
            // Any triplet that exceeds the target
            // in any position can never be used.
            //
            // Values can only stay the same or increase
            // during merging, never decrease.
            if (   triplet[0] > target[0]
                || triplet[1] > target[1]
                || triplet[2] > target[2])
            {
                continue;
            }

            // If this triplet matches target[0],
            // mark the first position as achievable.
            if (triplet[0] == target[0]) first = true;

            // If this triplet matches target[1],
            // mark the second position as achievable.
            if (triplet[1] == target[1]) second = true;

            // If this triplet matches target[2],
            // mark the third position as achievable.
            if (triplet[2] == target[2]) third = true;
        }

        // We can form the target triplet only if 
        // all three target positions are achievable.
        return first && second && third;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}