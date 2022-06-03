class Solution {
    public void sortColors(int[] A) {
        int n = A.length, i = 0, start = 0, end = n - 1;
        while(i <= end){
            if(A[i] == 0 && i != start){
                A[i] = A[start];
                A[start] = 0;
                start++;
            } else if(A[i] == 2){
                A[i] = A[end];
                A[end] = 2;
                end--;
            } else i++;
        }
    }
}