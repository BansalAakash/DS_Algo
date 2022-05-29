class Solution {
    void transpose(int[][] matrix){
        int n = matrix.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i > j){
                    matrix[i][j] = matrix[i][j] + matrix[j][i];
                    matrix[j][i] = matrix[i][j] - matrix[j][i];
                    matrix[i][j] = matrix[i][j] - matrix[j][i];
                }
            }
        }
    }
    void reverse(int[][] matrix){
        int n = matrix.length;
        for(int i = 0;i < n;i++){
            int start = 0, end = n - 1;
            while(start < end){
                matrix[i][start] += matrix[i][end];
                matrix[i][end] = matrix[i][start] - matrix[i][end];
                matrix[i][start] -= matrix[i][end];
                start++;end--;
            }
        }   
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}