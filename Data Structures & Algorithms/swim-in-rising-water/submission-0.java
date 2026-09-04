class Solution 
{
    public int swimInWater(int[][] grid) 
    {
        // Intialize N(grid's length).
        int N = grid.length;

        // Intialize a visit array(tracks which cell's are visited).
        boolean[][] visit = new boolean[N][N];

        // Intialize a minHeap.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Intialize a directions array.
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Start by offering the minHeap (starting cell value, row, col) and mark it in visit array.
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        // Run the djikstra's elgorithm.
        while (!minHeap.isEmpty())
        {
            // Extract the cell with the smallest time cost.
            int[] cur = minHeap.poll();

            // Get the time, row and col from the cell.
            int t = cur[0], r = cur[1], c = cur[2];

            // Handle if we reached the destination(return t).
            if (r == N - 1 && c == N - 1) return t;

            // Iterate over it's neighbors.
            for (int[] dir : directions)
            {
                // Compute the neighbors coordinate.
                int neiR = r + dir[0], neiC = c + dir[1];

                // Handle boundry check and also if already visited.
                if (neiR < 0 || neiC < 0 || neiR >= N || neiC >= N || visit[neiR][neiC])
                {
                    continue;
                }

                // Mark the neighbor cell.
                visit[neiR][neiC] = true;

                // Add the neighbor in the heap.
                minHeap.offer(new int[]{Math.max(t, grid[neiR][neiC]), neiR, neiC});
            } 
        }

        // Return grid length square as a fallback.
        return N * N;
    }
    // Time Complexity -> O(n square * log n)
    // Space Complexity -> O(n square)
}
