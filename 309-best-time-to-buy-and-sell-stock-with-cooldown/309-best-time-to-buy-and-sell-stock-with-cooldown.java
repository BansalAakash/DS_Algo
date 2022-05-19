class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, buy[0] + prices[1]);
        for(int i = 2;i < n;i++){
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(prices[i] + buy[i - 1], sell[i - 1]);
        }
        return sell[n - 1];
    }
}