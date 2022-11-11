class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, i = 0;
        if(n < 3)
            return false;
        while(i < n - 1 && arr[i] < arr[i + 1]) i++;
        if(i == 0)
            return false;
        int peak = i;
        while(i < n - 1 && arr[i] > arr[i + 1]) i++;
        if(i == peak)
            return false;
        
        return i == n - 1;
    }
}