class Solution {
    boolean searchRowBinary(int[][] A, int low, int high, int target){
        if(low > high) return false;
        int mid = low + (high - low) / 2;
        if(A[mid][0] > target) return searchRowBinary(A, low, mid - 1, target);
        return searchColBinary(A, mid, 0, A[0].length - 1, target) || searchRowBinary(A, mid + 1, high, target) || searchRowBinary(A, low, mid - 1, target);
    }
    boolean searchColBinary(int[][] A, int row, int low, int high, int target){
        if(low > high) return false;
        int mid = low + (high - low) / 2;
        if(A[row][mid] == target) return true;
        if(A[row][mid] > target) return searchColBinary(A, row, low, mid - 1, target);
        return searchColBinary(A, row, mid + 1, high, target);
    }
    public boolean searchMatrix(int[][] A, int target) {
        int m = A.length, n = A[0].length;
        return searchRowBinary(A, 0, m - 1, target);
    }
}