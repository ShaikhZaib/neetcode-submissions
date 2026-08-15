class Solution {
    public List<List<String>> solveNQueens(int n) 
    {
        // Initialize res list, col, pos and neg diagonal set
        List<List<String>> res = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        // Intialize empty board
        char[][] board = new char[n][n];
        for (char[] row : board)
        {
            Arrays.fill(row, '.');
        }

        // Call backtrack
        backtrack(res, col, posDiag, negDiag, board, n, 0);

        // Return res
        return res;
    }

    private void backtrack
    (
        List<List<String>> res, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag, 
        char[][] board, int n, int r
    )
    {
        // Handle base case
        if (r == n)
        {
            List<String> copy = new ArrayList<>();
            for (char[] row : board)
            {
                copy.add(new String(row));
            }
            res.add(copy);
        }

        // Loop through every column
        for (int c = 0; c < n; c++)
        {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c))
            {
                continue;
            }

            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(res, col, posDiag, negDiag, board, n, r + 1);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
    // Time Complexity -> O(n!)
    // Space Complexity -> O(n square)
}
