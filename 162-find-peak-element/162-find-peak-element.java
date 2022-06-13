class Solution {
    public int findPeakElement(int[] A) {
        int n = A.length, low = 0, high = n - 1;
        if(n == 1) return 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] > (mid == 0 ? Integer.MIN_VALUE : A[mid - 1]) && A[mid] > (mid == n - 1 ? Integer.MIN_VALUE : A[mid + 1]))
                return mid;
            if(mid == 0) low = mid + 1;
            else if(mid == n - 1) high = mid - 1;
            else if(A[mid] < A[mid - 1])
                high = mid - 1;
            else if(A[mid] < A[mid + 1])
                low = mid + 1;
        }
        return -1;
    }
}