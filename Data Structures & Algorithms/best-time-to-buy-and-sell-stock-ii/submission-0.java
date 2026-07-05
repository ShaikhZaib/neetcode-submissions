class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                int currentProfit = prices[i] - prices[i - 1];
                totalProfit += currentProfit;
            }
        }

        return totalProfit;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}