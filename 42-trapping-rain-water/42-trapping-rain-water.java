class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = 0;
        rightMax[n - 1] = 0;
        for(int i = 1;i < n;i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i]);
        }
        int water = 0;
        for(int i = 0;i < n;i++){
            int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
            water += temp < 0 ? 0 : temp;
        }
        return water;
    }
}