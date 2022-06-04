class Solution {
    void transpose(int[][] a){
        int n = a.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i > j){
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }
    }
    void reverse(int[][] A){
        int n = A.length;
        for(int i = 0;i < n;i++){
            int start = 0, end = n - 1;
            while(start < end){
                int temp = A[i][start];
                A[i][start] = A[i][end];
                A[i][end] = temp;
                start++;end--;
            }
        }
    }
    public void rotate(int[][] A) {
        transpose(A);
        reverse(A);
    }
}