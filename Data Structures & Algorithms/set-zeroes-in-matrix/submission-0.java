class Solution 
{
    public void setZeroes(int[][] matrix) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Indicates whether first row
        // should become all zeros.
        boolean firstRowZero = false;

        // Use first row and first column
        // as marker arrays.
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (matrix[r][c] == 0)
                {
                    // Mark column.
                    matrix[0][c] = 0;

                    if (r > 0)
                    {
                        // Mark row.
                        matrix[r][0] = 0;
                    }
                    else
                    {
                        // Remember that first row 
                        // originally contained a zero.
                        firstRowZero = true;
                    }
                }
            }
        }  

        // Zero cells using markers.
        for (int r = 1; r < rows; r++)
        {
            for (int c = 1; c < cols; c++)
            {
                if (matrix[r][0] == 0 || matrix[0][c] == 0)
                {
                    matrix[r][c] = 0;
                }
            }
        }

        // Zero first column if needed.
        if (matrix[0][0] == 0)
        {
            for (int r = 0; r < rows; r++)
            {
                matrix[r][0] = 0;
            }
        }

        // Zero first row if needed.
        if (firstRowZero)
        {
            for (int c = 0; c < cols; c++)
            {
                matrix[0][c] = 0;
            }
        }

        // Time Complexity -> O(m x n)
        // Space Complexity -> O(1)
    }
}