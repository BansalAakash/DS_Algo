class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, low = 0, high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int i = mid / n, j = mid % n;
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target)
                high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}