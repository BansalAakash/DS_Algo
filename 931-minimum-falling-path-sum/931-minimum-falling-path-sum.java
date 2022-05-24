class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, min = Integer.MAX_VALUE;
        if(m == 1) return matrix[0][0];
        for(int i = 1;i < m;i++){
            min = matrix[i][0] + matrix[i - 1][0];
            for(int j = 0;j < m;j++){
                int temp = matrix[i - 1][j];
                if(j > 0) temp = Math.min(temp, matrix[i - 1][j - 1]);
                if(j < m - 1) temp = Math.min(temp, matrix[i - 1][j + 1]);
                matrix[i][j] = temp + matrix[i][j];
                min = Math.min(min, matrix[i][j]);
            }
        }
        return min;
    }
}