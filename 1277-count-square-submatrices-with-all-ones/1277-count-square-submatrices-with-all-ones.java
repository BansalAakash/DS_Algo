class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0, prev = 0;
        int[] dp = new int[n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int temp = dp[j];
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0)
                        dp[j] = 1;
                    else dp[j] = Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
                    count += dp[j];
                }
                else
                    dp[j] = 0;
                prev = temp;
            }
        }
        return count;
    }
}