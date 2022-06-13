class Solution {
    public int findMin(int[] A) {
        int n = A.length, low = 0, high = n - 1, min = 5001;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] < (mid == 0 ? Integer.MAX_VALUE : A[mid - 1]) && A[mid] < (mid == n - 1 ? Integer.MAX_VALUE : A[mid + 1]))
                return A[mid];
            if(A[mid] < A[n - 1])
                high = mid - 1;
            else low = mid + 1;
        }
        return Integer.MAX_VALUE;
    }
}