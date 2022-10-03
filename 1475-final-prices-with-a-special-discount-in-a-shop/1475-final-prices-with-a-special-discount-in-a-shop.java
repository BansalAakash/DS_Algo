class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        for(int i = n - 1;i >= 0;i--){
            while(!stack.isEmpty() && stack.peek() > prices[i])
                stack.pop();
            int temp = prices[i];
            if(!stack.isEmpty())
                prices[i] -= stack.peek();
            stack.push(temp);
        }
        return prices;
    }
}