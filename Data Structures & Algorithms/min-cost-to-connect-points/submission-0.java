class Solution 
{
    public int minCostConnectPoints(int[][] points) 
    {
        // Intialize N(number of points in 2D coordinate).
        int n = points.length;
        
        // Intialzie minDist[] with integer.MAX_VALUE(tracks the min distance to connect it to MST).
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // Intialize inMST[] (tracks if the element is in MST).
        boolean[] inMST = new boolean[n];

        // Intialize totalCost and currentNode.
        int totalCost = 0;
        int currentNode = 0;

        // For every edge from 0 to n-1 run a loop
        for (int edge = 0; edge < n - 1; edge++)
        {
            // Mark the currentNode and intialize nextNode as -1.
            inMST[currentNode] = true;
            int nextNode = -1;

            // For evety node run a for loop.
            for (int i = 0; i < n; i++)
            {
                // If it's already visited skip it.
                if (inMST[i]) continue;

                // Calculate it's cost (manhattan distance).
                int cost = Math.abs(points[i][0] - points[currentNode][0]) +
                           Math.abs(points[i][1] - points[currentNode][1]);

                // If the cost is less update the minDist[i].
                minDist[i] = Math.min(minDist[i], cost);

                // Pick the smallest dist[i] i to be nextNode.
                if (nextNode == -1 || minDist[i] < minDist[nextNode])
                {
                    nextNode = i;
                }

            }
            // Add the minDist[nextNode] to totalCost and change the currentNode to nextNode.
            totalCost += minDist[nextNode];
            currentNode = nextNode;
        }

        // Return the totalCost.
        return totalCost;
    }
    // Time Complexity -> O(n square)
    // Space Coplexity -> O(n)
}
