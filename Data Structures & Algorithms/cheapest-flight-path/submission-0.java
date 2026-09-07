class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        // Intialize prices array(holds the minimum cost to reach each city).
        int[] prices = new int[n];

        // Intially every city is unreachable.
        Arrays.fill(prices, Integer.MAX_VALUE);

        // The source city has cost 0 because you start there.
        prices[src] = 0;

        // Outer loop runs k + 1 times.
        for (int i = 0; i <= k; i++)
        {
            // Intialize tmpPrices(snapshot of prices array).
            int[] tmpPrices = Arrays.copyOf(prices, n);

            // Loop through all flights.
            for (int[] flight : flights)
            {
                // Get s(source), d(destination) and p(price) from each flight.
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                // If the s city is unreachable skip this flight.
                if (prices[s] == Integer.MAX_VALUE) continue;

                // If going from s -> d is cheaper than current best known cost to d update it.
                if (prices[s] + p < tmpPrices[d])
                {
                    tmpPrices[d] = prices[s] + p;
                }
            }

            // Update prices to tmpPrices.
            prices = tmpPrices;
        }

        // If destination is still unreachable return -1  otherwise return the cheapest price found.
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
    // Time Complexity -> O(E . K)
    // Space Complexity -> O(V)
}
