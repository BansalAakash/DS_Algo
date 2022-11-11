class Solution {
    private int longestMountain(int[] arr) {
        int n = arr.length, max = 0;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1;i < n;i++)
            for(int j = 0;j < i;j++)
                if(arr[j] < arr[i] && left[j] >= left[i])
                    left[i] = left[j] + 1;
        for(int i = n - 2;i >= 0;i--){
            for(int j = n - 1;j > i;j--)
                if(arr[j] < arr[i] && right[j] >= right[i])
                    right[i] = right[j] + 1;
            if(left[i] != 1 && right[i] != 1 && left[i] + right[i] - 1 > max)
                max = left[i] + right[i] -1;
        }
        return max;
    }
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length, x = longestMountain(nums);
        return n - x;
    }
}