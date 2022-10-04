class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> lstack = new Stack<>();
        for(int i = 0;i < n;i++){
            while(!lstack.isEmpty() && nums[lstack.peek()] >= nums[i])
                lstack.pop();
            if(lstack.isEmpty())
                left[i] = -1;
            else left[i] = lstack.peek();
            lstack.push(i);
        }
        
        Stack<Integer> rstack = new Stack<>();
        for(int i = n - 1;i >= 0;i--){
            while(!rstack.isEmpty() && nums[rstack.peek()] >= nums[i])
                rstack.pop();
            if(rstack.isEmpty())
                right[i] = n;
            else right[i] = rstack.peek();
            rstack.push(i);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int max = 0;
        for(int i = 0;i < n;i++)
            max = Math.max((right[i] - left[i] - 1) * nums[i], max);
        return max;
    }
}