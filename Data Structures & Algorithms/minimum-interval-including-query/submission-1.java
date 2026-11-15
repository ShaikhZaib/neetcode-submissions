class Solution 
{
    public int[] minInterval(int[][] intervals, int[] queries) 
    {
        // Sort intervals by start value.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store: [query value, original index]
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++)
        {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Process queries in ascending order.
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap: 
        // [interval length, interval end]
        //
        // Heap top always contains 
        // the smallest valid interval.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] result = new int[queries.length];

        // Pointer for intervals.
        int intervalIndex = 0;

        for (int[] queryData : sortedQueries)
        {
            int query = queryData[0];
            int originalIndex = queryData[1];

            // Add all intervals whose
            // start <= current query.
            while (intervalIndex < intervals.length && 
                   intervals[intervalIndex][0] <= query)
            {
                int start = intervals[intervalIndex][0];
                int end = intervals[intervalIndex][1];

                int length = end - start + 1;

                minHeap.offer(new int[]{length, end});

                intervalIndex++;
            }

            // Remove intervlas that 
            // cannot contain query anymore.
            //
            // end < query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query)
            {
                minHeap.poll();
            }

            // Heap top now contains 
            // the smallest interval
            // containing this query.
            result[originalIndex] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return result;
    }
    // Time Compleixity -> O(N log N + Q log Q)
    //                      Q = Number of queries
    //                      N = Numver of intervals

    // Space Complexity -> O(N + Q)
}