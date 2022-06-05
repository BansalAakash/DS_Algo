class Solution {
    public int eraseOverlapIntervals(int[][] A) {
        Arrays.sort(A, (a, b) -> a[1] - b[1]);      //sorting based on ending position
        int n = A.length, count = 1;
        int end = A[0][1];
        for(int i = 1;i < n;i++){
            if(A[i][0] >= end){
                end = A[i][1];
                count++;
            }
        }
        return n - count;
    }
}