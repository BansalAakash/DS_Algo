class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[] dp = new int[n];
        for(int j = 0;j < n;j++){
            dp[j] = matrix[0][j] == '0' ? 0 : 1;
            if(dp[j] == 1)
                max = 1;
        }
        for(int i = 1;i < m;i++){
            int prev = dp[0];
            dp[0] = matrix[i][0] == '0' ? 0 : 1;
            if(dp[0] == 1)
                max = Math.max(max, dp[0]);
            for(int j = 1;j < n;j++){
                int temp = dp[j];
                if(matrix[i][j] == '0')
                    dp[j] = 0;
                else{
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
                }
                max = Math.max(max, dp[j]);
                prev = temp;
            }
        }
        return max * max;
    }
}