class Solution {
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public void sortColors(int[] A) {
        int n = A.length, i = 0, start = 0, end = n - 1;
        while(i <= end){
            if(A[i] == 0 && i != start){
                swap(A, i, start);
                start++;
            } else if(A[i] == 2 && i != end){
                swap(A, i, end);
                end--;
            } else i++;
        }
    }
}