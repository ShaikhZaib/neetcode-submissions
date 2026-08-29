// Intialize a DSU class.
class DSU
{
    // Intialize a parent array (tracks the root of eachs set).
    int[] parent;

    // Intialize a size array (tracks the size of the set).
    int[] size;

    // Constructor for DSU (allocates arrays of size n and each node as it's own parent node and set intial rank to 1).
    public DSU(int n)
    {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Intialize a find method (Find the root node for current node recursively using path compression and returns it).
    public int find (int node)
    {
        if (node != parent[node])
        {
            parent[node] = find(parent[node]);
        }

        return parent[node];    
    }

    // Intialize a union method (finds the parent node of both the node).
    public boolean union(int u, int v)
    {
        // Find the parent node.
        int pu = find(u);
        int pv = find(v);

        // If the parents node are the same return false.
        if (pu == pv) return false;

        // If the parent of u is smaller swap them.
        if (size[pv] > size[pu])
        {
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        // Update the parent of pv to be pu and pu's size by pv.
        parent[pv] = pu;
        size[pu] += size[pv];

        // Return true (Indicates that the merge has happened).
        return true;
    }
}

class Solution 
{
    public int countComponents(int n, int[][] edges) 
    {
        // Intialize a DSU (for n nodes) and res with n(tracks the sets).
        DSU dsu = new DSU(n);
        int res = n;

        // For each edge try to Union two nodes (if union secceeds decrement res by one).
        for (int[] edge : edges)
        {
            if (dsu.union(edge[0], edge[1])) res--;
        }

        // Return the res.
        return res;
    }
    // Time Complexity -> O(E + V)
    // Space Complexity -> O(V)
}
