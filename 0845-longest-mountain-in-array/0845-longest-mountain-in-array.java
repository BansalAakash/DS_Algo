class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length, max = 0;
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for(int i = 1;i < n;i++){
            if(arr[i] > arr[i - 1])
                left[i] = left[i - 1] + 1;
            else left[i] = 1;
            if(arr[n - i - 1] > arr[n - i])
                right[n - i - 1] = right[n - i] + 1;
            else right[n - i - 1] = 1;
        }
        for(int i = 1;i < n - 1;i++)
            if(left[i] != 1 && right[i] != 1)
                max = Math.max(max, left[i] + right[i] - 1);
        return max;
    }
}