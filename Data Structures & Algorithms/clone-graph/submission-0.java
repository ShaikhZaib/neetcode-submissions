/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution 
{
    public Node cloneGraph(Node node) 
    {
        // Create a Map that copies the copy node to the original
        Map<Node, Node> oldToNew = new HashMap<>();

        // Run dfs on the parent node and return it
        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew)
    {
        // Handle null check
        if (node == null)
        {
            return null;
        }

        // Check if we already copied the node
        if (oldToNew.containsKey(node))
        {
            return oldToNew.get(node);
        }

        // Create a new node and add it in the map
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        // Recursively run dfs on all of it's neighbors
        for (Node nei : node.neighbors)
        {
            copy.neighbors.add(dfs(nei, oldToNew));
        }

        // Return the copy node
        return copy;
    }
    // Time Complexity -> O(V + E)
    // Space Complexity -> O(V)
}









