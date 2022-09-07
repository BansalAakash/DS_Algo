class Solution {
    private boolean binarySearch(int[][] matrix, int target, int low, int high, int n){
        if(low > high)
            return false;
        int mid = low + (high - low) / 2, midElem = matrix[mid / n][mid % n];
        if(midElem == target)
            return true;
        else if(midElem > target)
            return binarySearch(matrix, target, low, mid - 1, n);
        return binarySearch(matrix, target, mid + 1, high, n);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
         return binarySearch(matrix, target, 0, m * n - 1, n);
    }
}