class Solution {
    public int maxProfit(int[] prices) {
        int result = 0, prevMin = Integer.MAX_VALUE;
        for(int i : prices){
            result = Math.max(result, i - prevMin);
            prevMin = Math.min(i, prevMin);
        }
        return result;
    }
}