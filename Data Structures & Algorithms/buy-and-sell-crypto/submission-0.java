class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for(int price : prices){
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }

        return maxProfit;
    }

    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}
