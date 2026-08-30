// Intialize a DSU class.
class DSU
{
    // Intialize parent array(stores the parent) and size array(stores the size).
    int[] parent;
    int[] size;
 
    // Intialize a constructur for size n where the arrays size is n + 1 and all arrays are their own parent and their size is 1.
    public DSU(int n)
    {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Intialize a find method which finds the parent of a node recursively.
    public int find(int x)
    {
        if (parent[x] != x)
        {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Intialize a union method which merge two nodes.
    public boolean union(int y, int z)
    {
        // Find the parent of two nodes.
        int py = find(y);
        int pz = find(z);

        // If both share the same parent return false.
        if (py == pz) return false;

        // Change the parent node of whichever node is smaller and add its size in the bigger node.
        if (size[py] < size[pz])
        {
            parent[py] = pz;
            size[pz] += size[py];
        }
        else
        {
            parent[pz] = py;
            size[py] += size[pz];
        }

        // Return true.
        return true;
    }
}

class Solution 
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        // Intialize a DSU of size edges length.
        DSU dsu = new DSU(edges.length);

        // For every edge in the edge array run union method if it falls return that edge.
        for (int[] edge : edges)
        {
            if (!dsu.union(edge[0], edge[1])) 
            {
                return edge;
            }
        }

        // If the loop fails return an empty array.
        return new int[0];
    }
    // Time Complexity -> O(E)
    // Space Complexity -> O(V)
}