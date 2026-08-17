public class TrieNode
{
    HashMap<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode()
    {
        children = new HashMap<>();
        endOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        // Intialize cur as root
        TrieNode cur = root;

        // Add every character in the trie
        for (char c : word.toCharArray())
        {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }

        // Mark the end of word
        cur.endOfWord = true;
    }

    public boolean search(String word) 
    {
        // Call dfs
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index)
    {
        // Intialize cur as node 
        TrieNode cur = node;

        // For every character in trie from index search for the children
        for (int i = index; i < word.length(); i++)
        {
            // Get the current character
            char c = word.charAt(i);

            // Handle "." and regular character
            if (c == '.')
            {
                for (TrieNode child : cur.children.values())
                {
                    if (dfs(child, word, i + 1))
                    {
                        return true;
                    }
                }
            return false;
            }
            else 
            {
                if (!cur.children.containsKey(c))
                {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }

        // Return if word exists
        return cur.endOfWord;
    }
    // Time Complexity -> O(v)
    // Space Complexity -> O(t + n)
}
