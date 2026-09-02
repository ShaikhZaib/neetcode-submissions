class Solution 
{
    public List<String> findItinerary(List<List<String>> tickets) 
    { 
        // Intialze a graph adjacency list.
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets)
        {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        // Intilaize a res linkedList and stack(deque) and push jfk in the stack.
        LinkedList<String> res = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        // Hierholzer’s algorithm for Eulerian path.
        while (!stack.isEmpty())
        {
            // Peek the topmost element in the stack.
            String curr = stack.peek();

            // If no outgoing flights are left add it in the front of the list, else take the destination and push it in the stack.
            if (!graph.containsKey(curr) || graph.get(curr).isEmpty())
            {
                res.addFirst(stack.poll());
            }
            else
            {
                stack.push(graph.get(curr).poll());
            }
        }  
        
        return res;
    }
        // Time Complexity -> O(E log E)
        // Space Complexity -> O(E)      
}
