class Solution 
{
    public int climbStairs(int n) 
    {
        // Handle for n 2 and less than 2.
        if (n <= 2) return n;

        // Intialize current(stores how many steps it takes to reach current stair).
        int current = 1;

        // Intialize previous(stores how many steps it takes to reach previous stair).
        int previous = 1;

        // Run a for loop from 2 to n and increment current and previous. 
        for (int i = 2; i <= n; i++)
        {
            int temp = current;
            current = current + previous;
            previous = temp;
        }

        // Return current.  
        return current;  
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
