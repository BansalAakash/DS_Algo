class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max = 0, n = nums.length;
        for(int i = 1; i < n;i++)
            if(nums[i] > nums[max])
                max = i;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int i = max, count = 0;
        while(count <= n){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            if(stack.isEmpty()) result[i] = -1; 
            else result[i] = nums[stack.peek()];
            // System.out.println("result[" + i + "] is " + result[i]);
            stack.push(i);
            i = (i > 0) ? i - 1 : n - 1;
            count++;
        }
        return result;
    }
}