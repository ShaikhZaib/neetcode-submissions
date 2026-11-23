class Solution 
{
    public void rotate(int[][] matrix) 
    {
        // Current layer boundaries.
        int left = 0;
        int right = matrix.length - 1;

        // Process one layer at a time.
        while (left < right)
        {
            int top = left;
            int bottom = right;

            // Rotate all elements in the current layer.
            for (int i = 0; i < right - left; i++)
            {
                // Save top-left value.
                int topLeft = matrix[top][left + i];

                // Bottom-left -> Top-left.
                matrix[top][left + i] = matrix[bottom - i][left];

                // Bottom-right -> Bottom-left.
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // Top-right -> Bottom-right.
                matrix[bottom][right - i] = matrix[top + i][right];

                // Saved top-left -> Top-right.
                matrix[top + i][right] = topLeft;
            }

            // Move to the next inner layer.
            left++;
            right--;
        }   
        // Time Complexity -> O(n square);
        // Space Complexity -> O(1) 
    }
}