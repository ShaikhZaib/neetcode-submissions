class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> result = new ArrayList<>();

        // Current boundaries of the remaining matrix.
        int left = 0;
        int right = matrix[0].length;

        int top = 0;
        int bottom = matrix.length;

        // Continue while there is still a layer left.
        while (left < right && top < bottom)
        {
            // Traverse left -> right.
            for (int row = left; row < right; row++)
            {
                result.add(matrix[top][row]);
            }
            top++;

            // Traverse top -> bottom.
            for (int col = top; col < bottom; col++)
            {
                result.add(matrix[col][right - 1]);
            }
            right--;

            // Prevent duplicate traversal
            // in single-row / single-column cases.
            if (!(left < right && top < bottom)) break;
            
            // Traverse right -> left.
            for (int row = right - 1; row >= left; row--)
            {
                result.add(matrix[bottom - 1][row]);
            }
            bottom--;
            
            // Traverse bottom -> top.        
            for (int col = bottom - 1; col >= top; col--)
            {
                result.add(matrix[col][left]);
            }
            left++;
        }    

        return result;
    }
    // Time Complexity -> O(m x n)
    // Space Compleixty -> O(1) (Auxilary)
}