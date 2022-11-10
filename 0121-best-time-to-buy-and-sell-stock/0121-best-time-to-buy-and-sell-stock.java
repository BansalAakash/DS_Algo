class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, prev = prices[0], n = prices.length;
        for(int i = 1;i < n;i++)
            if(prices[i] > prev)
                max = Math.max(max, prices[i] - prev);
            else
                prev = prices[i];
        
        return max;
    }
}