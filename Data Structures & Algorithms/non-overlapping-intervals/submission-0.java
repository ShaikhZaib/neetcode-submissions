class Solution 
{
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        // Sort intervals by start time.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Number of intervals removed.
        int removed = 0;

        // End of the previous interval 
        // that we're currently keeping.
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // No overlap.
            // Keep this interval and update prevEnd.
            if (start >= prevEnd)
            {
                prevEnd = end;
            }
            else
            {
                // Overlap detected.
                removed++;

                // Keep the interval with the 
                // smaller ending point because 
                // it leaves more room for future intervals.
                prevEnd = Math.min(prevEnd, end);
            }
        }

        return removed;
    }
    // Time Complexity -> O(n log n)
    // Space Complexity -> O(1) (If we forgo the space for sorting)
}