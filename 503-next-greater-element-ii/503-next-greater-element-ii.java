class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i = 1;i < n;i++){
            if(nums[i] > nums[max])
                max = i;
        }
        
        int i = max, count = 0;
        while(count++ < n){
            while(!stack.isEmpty() && nums[i] >= stack.peek()) stack.pop();
            if(stack.isEmpty())
                result[i] = -1;
            else result[i] = stack.peek();
            stack.push(nums[i]);
            i = i == 0 ? n - 1 : i - 1;
        }
        return result;
    }
}