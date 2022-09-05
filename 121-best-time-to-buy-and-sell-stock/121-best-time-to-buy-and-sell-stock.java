class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int low = prices[0], max = 0;
        for(int i = 1;i < prices.length;i++){
            low = Math.min(low, prices[i]);
            max = Math.max(max, prices[i] - low);
        }
        return max;
    }
}