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
    public int minMeetingRooms(List<Interval> intervals) 
    {
        int n = intervals.size();

        // Store all start times.
        int[] start = new int[n];

        // Store all end times.
        int[] end = new int[n];

        // Separate starts and ends.
        for (int i = 0; i < n; i++)
        {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        // Sort start times.
        Arrays.sort(start);

        // Sort end times.
        Arrays.sort(end);

        // Maximum rooms needed.
        int rooms = 0;

        // Current rooms in use.
        int currentRooms = 0;

        // Pointer for start times.
        int startPtr = 0;

        // Pointer for end times.
        int endPtr = 0;

        while (startPtr < n)
        {
            // Next meeting starts before 
            // the earliest meeting ends.
            if (start[startPtr] < end[endPtr])
            {
                // Need a  new room.
                currentRooms++;
                startPtr++;
            }
            // A meeting ended first.
            else
            {
                // Free a room.
                currentRooms--;
                endPtr++;
            }

            // Track the maximum rooms
            // occupied at any time.
            rooms = Math.max(rooms, currentRooms);
        }
        
        return rooms;
    }
    // Time Complexity -> O(n log n)
    // Space Complexity -> O(n)
}
