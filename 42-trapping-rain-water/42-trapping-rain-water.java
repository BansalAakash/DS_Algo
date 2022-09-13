class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if(len < 3)
            return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 1;i < len;i++){
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[len - i - 1] = Math.max(right[len - i], height[len - i]);
        }
        int result = 0;
        for(int i = 1;i < len - 1;i++){
            int temp = Math.min(left[i], right[i]);
            result += height[i] > temp ? 0 : temp - height[i];
        }
        return result;
    }
}