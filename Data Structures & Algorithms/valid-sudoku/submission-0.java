class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char currChar = board[row][col];
                if(currChar == '.') continue;

                String squareKey = (row / 3) + "," + (col / 3);

                if(rows.computeIfAbsent(row, k -> new HashSet<>()).contains(currChar) ||
                   cols.computeIfAbsent(col, k -> new HashSet<>()).contains(currChar) ||
                   squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(currChar)
                ){
                    return false;
                }

                rows.get(row).add(currChar);
                cols.get(col).add(currChar);
                squares.get(squareKey).add(currChar);
            }
        }

        return true;
    }
}
