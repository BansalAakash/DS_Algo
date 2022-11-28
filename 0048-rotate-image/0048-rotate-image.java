class Solution {
    void inverse(int[][] m, int n){
        for(int i = 0;i < n / 2;i++){
            for(int j = 0;j < n;j++){
                int temp = m[i][j];
                m[i][j] = m[n - i - 1][j];
                m[n - i - 1][j] = temp;
            }
        }
    }
    void transpose(int[][] m, int n){
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        inverse(matrix, n);
        transpose(matrix, n);
    }
}