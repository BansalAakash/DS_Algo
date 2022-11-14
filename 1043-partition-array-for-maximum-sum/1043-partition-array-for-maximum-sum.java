import java.util.*;
class Solution {
	int f(int[] arr, int n, int k, int i, int[] dp){
		if(i == n)
			return 0;
        if(dp[i] != -1)
            return dp[i];
		int sum = 0, max = 0;
		for(int j = i;j < Math.min(i + k, n);j++){
			max = Math.max(max, arr[j]);
			int cur = max * (j - i + 1) + f(arr, n, k, j + 1, dp);
			sum = Math.max(sum, cur);
		}
		return dp[i] = sum;
	}
    public int maxSumAfterPartitioning(int[] arr, int k) {
    	int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(arr, n, k, 0, dp);
    }
}