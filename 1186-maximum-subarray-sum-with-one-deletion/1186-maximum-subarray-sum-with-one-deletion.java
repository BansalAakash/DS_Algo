class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length, max = arr[0];
        int left[] = new int[n], right[] = new int[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for(int i = 1;i < n;i++){
            left[i] = arr[i] + Math.max(0, left[i - 1]);
            right[n - i - 1] = arr[n - i - 1] + Math.max(0, right[n - i]);
            max = Math.max(max, left[i]);                                   // No deletions
        }
        for(int i = 1;i < n - 1;i++)
            max = Math.max(max, left[i - 1] + right[i + 1]);
        return max;
    }
}