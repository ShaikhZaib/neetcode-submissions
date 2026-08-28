class Solution 
{
    public boolean validTree(int n, int[][] edges) 
    {
        // Check the edges(for n number of nodes the edges must be n-1).
        if (edges.length != n - 1) return false;

        // Build the adjacent graph and intialized it with an empty list.
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list. 
        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Intialize a visited set(tracks visited nodes).
        Set<Integer> visited = new HashSet<>();

        // Start the dfs from node 0(also pass the parent node to handle falsely detecting the edge back to the parent as a cycle).
        if (!dfs(0, -1, adjList, visited))
        {
            return false;
        }

        // if all nodes were visited true or false.
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adjList, Set<Integer> visited)
    {
        // Check if we revisit the node already visited return false(cycle detected).
        if (visited.contains(node)) return false;

        // Mark the node.
        visited.add(node);

        // Explore all the neighbors and skip the parent.
        for (int nei : adjList.get(node))
        {
            if (nei == parent) continue;

            if (!dfs(nei, node, adjList, visited)) return false;
        }

        // Return true(no cycles were found).
        return true;
    }
    // Time Complexity -> O(V + E).
    // Space Complexity -> O(V + E).
}
