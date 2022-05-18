class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, i = 0, j = 0;
        while(i < prices.length && j < prices.length){
            while(j < prices.length - 1 && prices[j + 1] < prices[j])j++;           //j is the local minimum now
            i = j + 1;
            while(i < prices.length - 1 && prices[i + 1] > prices[i])i++;           //i is the local maximum now
            profit += i < prices.length ? prices[i] - prices[j] : 0;
            j = i + 1;
        }
        return profit;
    }
}