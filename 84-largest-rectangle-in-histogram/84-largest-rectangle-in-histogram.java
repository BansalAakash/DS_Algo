class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if(stack.isEmpty())
                left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
        
        while(!stack.isEmpty()) stack.pop();
        for(int i = n - 1;i >= 0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if(stack.isEmpty())
                right[i] = n;
            else right[i] = stack.peek();
            stack.push(i);
        }
        int max = 0;
        for(int i = 0;i < n;i++)
            max = Math.max((right[i] - left[i] - 1) * nums[i], max);
        return max;
    }
}