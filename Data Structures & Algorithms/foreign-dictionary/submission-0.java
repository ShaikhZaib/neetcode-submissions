class Solution 
{
    // Declare the adjacancy graph
    // (maps each character to the set of characters that must come after it)
    private Map<Character, Set<Character>> graph;

    // Declare the state HashMap(track DFS state).
    private Map<Character, State> state;

    // Declare result list(order -> stores characters in topological order).
    private List<Character> order;

    // Make an Enum visited states.
    private enum State 
    {
        UNVISITED,
        VISITING,
        VISITED
    }

    public String foreignDictionary(String[] words) 
    {
       // Intialize the graph, state, and order.
       graph = new HashMap<>();
       state = new HashMap<>();
       order = new ArrayList<>();

       // Intialize the graph with all characters.
       for (String word : words)
       {
        for (char c : word.toCharArray())
        {
            graph.putIfAbsent(c, new HashSet<>());
            state.putIfAbsent(c, State.UNVISITED);
        }
       }

       // Build edges based on word order.
       for (int i = 0; i < words.length - 1; i++)
       {
        String w1 = words[i], w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());

        // Invalid case: prefix rule violation.
        if (w1.length() > w2.length() && w1.startsWith(w2))
        {
            return "";
        }

        // First offering character defines ordering.
        for (int j = 0; j < minLen; j++)
        {
            if (w1.charAt(j) != w2.charAt(j))
            {
                graph.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
       }

       // DFS for topological sort.
       for (char c : graph.keySet())
       {
        if (state.get(c) == State.UNVISITED)
        {
            if (dfs(c)) return "";
        }
       }

       // Reverse order to get correct topologica sort.
       Collections.reverse(order);
       StringBuilder sb = new StringBuilder();
       for (char c : order) sb.append(c);
       return sb.toString();
    }

    private boolean dfs(char ch)
    {
        state.put(ch, State.VISITING);

        for (char next : graph.get(ch))
        {
            if (state.get(next) == State.VISITING) return true;
            if (state.get(next) == State.UNVISITED && dfs(next)) return true;
        }

        state.put(ch, State.VISITED);
        order.add(ch);
        return false;
    }
    // Time Complexity -> O(N + V + E)
    // Space Complexity -> O(V + E)
}
