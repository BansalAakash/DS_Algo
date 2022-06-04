class Solution {
    public int smallestRangeII(int[] A, int k) {
        Arrays.sort(A);
        int n = A.length, left = A[0] + k, right = A[n - 1] - k, result = A[n - 1] - A[0];
        if(n < 2) return 0;
        for(int i = 0;i < n - 1;i++){
            int curMax = Math.max(A[i] + k, right);
            int curMin = Math.min(A[i + 1] - k, left);
            result = Math.min(result, curMax - curMin);
        }
        return result;
    }
}