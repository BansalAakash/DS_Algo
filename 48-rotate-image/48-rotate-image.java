class Solution {
    public void rotate(int[][] A) {
        int n = A.length;
        
        //reverse horizontally
        for(int i = 0;i < n;i++){
            int j = 0, k = n - 1;
            while(j < k){
                int temp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = temp;
                j++;k--;
            }
        }
        
        //transpose by right diagonal
        for(int i = 0;i < n - 1;i++){
            for(int j = 0;i + j < n - 1;j++){
                int temp = A[i][j];
                A[i][j] = A[n - j - 1][n - i - 1];
                A[n - j - 1][n - i - 1] = temp;
            }
        }
    }
}