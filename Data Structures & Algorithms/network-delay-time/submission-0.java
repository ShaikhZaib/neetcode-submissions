class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        // Build an adjacency list edge(first intialize the edges Map(key -> Integer, value -> list of integer array) and loop through time in times and add the edges but first use computeIfAbsent to check if it has the node list before adding the element.
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times)
        {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Intialize a minHeap and start with source k at distance 0.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});

        // Intialize a visited set(to ensure each node is visited only once) and t(tracks the maximum time when a node is reached).
        Set<Integer> visited = new HashSet<>();
        int t = 0;

        // Run a while loop untill the minheap is not empty.
        while (!minHeap.isEmpty())
        {
            // Extract the node with the smallest distance and weight and node from that node.
            int[] curr = minHeap.poll();
            int w1 = curr[0], n1 = curr[1];

            // If it's already visited skip it.
            if (visited.contains(n1)) continue;

            // Mark it visited and update t to the current shortest distance.
            visited.add(n1);
            t = w1;

            // For each neighbor if n1 exists in the edge adjacency list extract their weight and node and if it's not visited push  [new weight(previous weight + current weight), neighbor]  into the heap.
            if (edges.containsKey(n1))
            {
                for (int[] next : edges.get(n1))
                {
                    int n2 = next[0], w2 = next[1];
                    if (!visited.contains(n2))
                    {
                        minHeap.offer(new int[]{w1 + w2, n2});
                    }
                }
            }
        }

        // if all nodes are reached return the max distance otherwise return -1.    
        return visited.size() == n ? t : -1;
    }
    // Time Complexity -> O(E log V)
    // Space Complexity -> O(E + V)
}
