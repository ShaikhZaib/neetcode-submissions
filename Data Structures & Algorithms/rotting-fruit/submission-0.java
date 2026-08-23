class Solution
{
    public int orangesRotting(int[][] grid) 
    {
        // Intialize queue for storing rotten oranges, and variables fot storing fresh orange and time.
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        // Loop through each cell in the grid and count fresh oranges and enqueue rotten one in the queue.
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                if (grid[r][c] == 1) fresh++;
                if (grid[r][c] == 2) q.add(new int[]{r, c});
            }
        }

        // Initialize an direction array.
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Run a loop while there are fresh oranges available and rotten oranges
        while (fresh > 0 && !q.isEmpty())
        {
            // Calculate the length of the queue and run the for loop on it.
            int length = q.size();
            for (int i = 0; i < length; i++)
            {
                // Calculate the coordinate for the rotten orange, and rot all of it's neighbors
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for(int[] dir : directions)
                {
                    // Calculate coordinates.
                    int row = r + dir[0];
                    int col = c + dir[1];

                    // Check for fresh oranges and rot them
                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1)
                    {
                        grid[row][col] = 2;
                        q.add(new int[]{row, col});
                        fresh--;
                    }
                }
            }

            // Increse the time
            time++;
        }

        // Return 0 if there are any fresh oranges left or time it took to rotten them.   
        return fresh == 0 ? time : -1; 
    }
    // Time Complexity -> O(m.n)
    // Space Complexity -> O(m.n)
}
