class Solution 
{
   public int canCompleteCircuit(int[] gas, int[] cost)
   {
    // Total gas available in all stations.
    int totalGas = 0;

    // Total cost required to travel
    // around the entire circuit.
    int totalCost = 0;

    // Current gas balance while testing
    // a candidate starting station.
    int currentGas = 0;

    // Current candidate answer.
    int startIndex = 0; 

    for (int i = 0; i < gas.length; i++)
    {
        totalGas += gas[i];
        totalCost += cost[i];

        // Gas left after traveling
        // from status i to i + 1.
        currentGas += gas[i] - cost[i];

        // Cannot reach the next station.
        if (currentGas < 0)
        {
            // All stations from the current 
            // startIndex to i are invalid.
            startIndex = i + 1;

            // Start fresh from the next station.
            currentGas = 0;
        }
    }

    // If total gas is less than total cost, 
    // completing the circuit is impossible.
    return (totalGas < totalCost) ? -1 : startIndex;
   }
   
   // Time Complexity -> O(n)
   // Space Complexity -> O(1)
}