public class TrieNode
{
    // Intialize the HashMap and endOfWord
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree 
{
    private TrieNode root;

    public PrefixTree() 
    {
        // Intialize the root TrieNode
        root = new TrieNode();
    }

    public void insert(String word) {
        // Intialize a cur TrieNode as root
        TrieNode cur = root;

        // Insert every character
        for (char c : word.toCharArray())
        {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }

        // Mark endOfWord as true
        cur.endOfWord = true;
    }

    public boolean search(String word) 
    {
        // Intialize a cur TrieNode as root
        TrieNode cur = root;

        // Check every character in the word
        for (char c : word.toCharArray())
        {
            if (!cur.children.containsKey(c))
            {
                return false;
            }
            cur = cur.children.get(c);
        }

        // Return if the last char is an endOfWord
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) 
    {
        // Intialize a cur TrieNode as root
        TrieNode cur = root;

        // Check every characters in the word
        for (char c : prefix.toCharArray())
        {
            if (!cur.children.containsKey(c))
            {
                return false;
            }
            cur = cur.children.get(c);
        }

        // Return true
        return true;
    }
}
