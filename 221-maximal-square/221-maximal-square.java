class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = 0, prev = 0;
        int[] dp = new int[n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int temp = dp[j];
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0)
                        dp[j] = 1;
                    else 
                        dp[j] = Math.min(dp[j - 1], Math.min(prev, dp[j])) + 1;
                    max = Math.max(max, dp[j]);
                } else 
                    dp[j] = 0;
                prev = temp;
            }
        }
        return max * max;
    }
}