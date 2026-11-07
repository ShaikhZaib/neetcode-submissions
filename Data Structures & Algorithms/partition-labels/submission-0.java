class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        List<Integer> result = new ArrayList<>();

        // Stores the last occurence of each character.
        Map<Character, Integer> lastIndex = new HashMap<>();

        // Record the last position where each character appears.
        for (int i = 0, n = s.length(); i < n; i++)
        {
            lastIndex.put(s.charAt(i), i);
        }

        // Current partition size.
        int size = 0;

        // Furthest index this partition must reach.
        int end = 0;

        for (int i = 0, n = s.length(); i < n; i++)
        {
            // Add current character to partition.
            size++;

            // Extent partition if this character 
            // appears later in the string.
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            // If we've reached the furthest required index,
            // the partition can safely end here.
            if (i == end)
            {
                // Store partition size.
                result.add(size);

                // Reset size for the next partition.
                size = 0;
            }
        }    

        return result;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}