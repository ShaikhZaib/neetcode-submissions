class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        // Sort intervals by start time.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Current interval being merged.
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++)
        {
            // Overlap exists.
            if (intervals[i][0] <= current[1])
            {
                // Extend the ending point.
                current[1] = Math.max(current[1], intervals[i][1]);
            }
            else
            {
                // Current interval is finalized.
                result.add(current);
            
                // Start a new interval.
                current = intervals[i];
            }
        }

        // Add the final interval.
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
    // Time Complexity -> O(n log n)
    // Space Complexity -> O(n)
}