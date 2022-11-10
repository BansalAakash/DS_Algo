class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 0, sell = 0;
        for(int j = n - 1;j >= 0;j--){
            int tempBuy = Math.max(sell - prices[j], buy);
            int tempSell = Math.max(buy + prices[j], sell);
            sell = tempSell;
            buy = tempBuy;
        }
        return buy;
    }
}

//1 signifies -> canBuy (meaning right now we dont have a share)
//0 signfies -> canSell (meaning we have a share right now)