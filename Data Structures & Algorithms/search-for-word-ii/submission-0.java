// Declare TrieNode class
private static class TrieNode
{
    // Declare children and isWord
    HashMap<Character, TrieNode> children;
    boolean isWord;

    // Declare constructor
    public TrieNode()
    {
        children = new HashMap<>();
        isWord = false;
    }

    // Make addWord method
    public void addWord(String word)
    {
        TrieNode cur = this;
        for (char c : word.toCharArray())
        {
            cur.children.computeIfAbsent(c, k -> new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution 
{
    // Declare res set and visit array
    private HashSet<String> res;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) 
    {
        // Intialize the root node and add all the words
        TrieNode root = new TrieNode();
        for (String word : words)
        {
            root.addWord(word);
        }

        // Intialize ROWS, COLS, res, visit
        int ROWS = board.length;
        int COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        // Loop over rows and cols and call dfs
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                dfs(board, root, r, c, "");
            }
        }

        // Return res    
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, TrieNode node, int r, int c, String word)
    {
        // Intialize ROWS and COLS
        int ROWS = board.length;
        int COLS = board[0].length;

        // Handle boundry condition and pruning conditions
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visit[r][c] || !node.children.containsKey(board[r][c]))
        {
            return;
        }

        // Mark the current word in visti array and advance to the next children and add the character to the word, and if the word exists add it in the res 
        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.isWord)
        {
            res.add(word);
        }

        // Explore in all directions 
        dfs(board, node, r + 1, c, word);
        dfs(board, node, r - 1, c, word);
        dfs(board, node, r, c + 1, word);
        dfs(board, node, r, c - 1, word);

        // Unmark the current word
        visit[r][c] = false;
    }
    // Time Complexity -> O(mn . 4 * 3 raise to t - 1 + s)
    // Space Complexity -> O(s)
}
