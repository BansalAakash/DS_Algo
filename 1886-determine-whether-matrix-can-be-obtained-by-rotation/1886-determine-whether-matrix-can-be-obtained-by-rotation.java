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
    void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    boolean matches(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                if(mat[i][j] != target[i][j]) return false;
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int m = mat.length, n = target.length;
        if(m != n) return false;
        for(int i = 0;i < 4;i++){
            rotate(mat);
            if(matches(mat, target)) return true;
        }
        return false;
    }
}