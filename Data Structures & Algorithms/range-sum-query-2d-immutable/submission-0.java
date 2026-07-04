class NumMatrix {
    private int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        sumMat = new int[rows + 1][cols + 1];

        for(int row = 0; row < rows; row++){
            int prefixSum = 0;
            for(int col = 0; col < cols; col++){
                prefixSum += matrix[row][col];
                int above = sumMat[row][col + 1];
                sumMat[row + 1][col + 1] = prefixSum + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1 - 1][col2];
        int left = sumMat[row2][col1 - 1];
        int topLeft = sumMat[row1 - 1][col1 - 1];

        return bottomRight - above - left + topLeft;
    }
    // Time Complexity -> O(1)
    // Space Complexity -> O(n * m)
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */