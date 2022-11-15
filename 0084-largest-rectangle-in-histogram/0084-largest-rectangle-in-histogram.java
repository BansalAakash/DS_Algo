class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length, max = 0, left = 0, right = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i <= n;i++){
            int cur = i < n ? h[i] : Integer.MIN_VALUE;
            while(!stack.isEmpty() && cur < h[stack.peek()]){
                int x = stack.pop();
                right = i - 1;
                left = stack.isEmpty() ? 0 : stack.peek() + 1;
                max = Math.max(h[x] * (right - left + 1), max);
            }
            if(i < n)
                stack.push(i);
        }
        return max;
    }
}