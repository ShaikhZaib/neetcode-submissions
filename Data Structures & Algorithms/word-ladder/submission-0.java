class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        // Handle if endWord is not in the list and beginWord is equal to endWord.
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        // Convert the list to a set and intialize a res variable (tracks the number of transformation).
        Set<String> words = new HashSet<>(wordList);
        int res = 0;

        //  Intialize a queue and start bfs with the beginWord.
        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        // Run bfs untill the queue is empty.
        while (!q.isEmpty())
        {
            // Increase the transformation.
            res++;

            // Process all the nodes at the current level by decreasing order.
            for (int i = q.size(); i > 0; i--)
            {
                // Get the current node.
                String node = q.poll();

                // Check if it's endWord(if it is return res).
                if (node.equals(endWord)) return res;

                // For each character in the word replace it with a-z.
                for (int j = 0, n = node.length(); j < n; j++)
                {
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        // If it's the same character skip.
                        if (c == node.charAt(j)) continue;

                        // Make the neighbor word by replacing one character.
                        String nei = node.substring(0, j) + c + node.substring(j + 1);

                        // If the neighbor exists in dictionary add it in queue and remove it from words                        .                      (to avoid revisiting).
                        if (words.contains(nei))
                        {
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }
                }
            }  
        }

        // If bfs finishes without finding endWord return 0;    
        return 0;
    }
    // Time Complexity -> O(n . m square)
    // Space Complexity -> O(n . m square)
}
