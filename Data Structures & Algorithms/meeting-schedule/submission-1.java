/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution 
{
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        // Sort meetings by start time.
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        // Compare each meeting with the previous one.
        for (int i = 1, n = intervals.size(); i < n; i++)
        {
            Interval previous = intervals.get(i - 1);
            Interval current = intervals.get(i);

            // Overlap exists if the previous meeting
            // ends after the current meeting starts.
            if (previous.end > current.start) return false;
        }

        // No overlaps found.
        return true;
    }
    // Time Complexity -> O(n log n)
    // Space Complexity -> O(1) (If we forgo the sorting space)
}
