class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, min = Integer.MAX_VALUE;
        if(m == 1) return matrix[0][0];
        for(int i = 1;i < m;i++){
            min = matrix[i][0] + matrix[i - 1][0];
            for(int j = 0;j < m;j++){
                matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][Math.max(0, j - 1)], matrix[i - 1][Math.min(m - 1, j + 1)]));
                min = Math.min(min, matrix[i][j]);
            }
        }
        return min;
    }
}