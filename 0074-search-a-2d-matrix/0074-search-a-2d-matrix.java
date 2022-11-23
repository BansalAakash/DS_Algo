class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length, high = m * n - 1, low = 0;
        while(low <= high){
            int mid = low + (high - low) / 2, i = mid / n, j = mid % n;
            if(mat[i][j] == target)
                return true;
            if(mat[i][j] < target)
                low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}