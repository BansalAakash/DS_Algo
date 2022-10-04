import java.util.*;
class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length, cur = 0, max = 0, left = 0, right = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i <= n;i++){
            while(!stack.isEmpty() && (i == n || nums[i] < nums[stack.peek()])){
                cur = stack.pop();
                left = stack.isEmpty() ? -1 : stack.peek();
                right = i;
                max = Math.max(max, (right - left - 1) * nums[cur]);
            }
            stack.push(i);
        }
        return max;
    }
}