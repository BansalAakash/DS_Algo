class Solution {
    public int longestMountain(int[] arr) {
        int max = 0, start = 0, end = 0, n = arr.length, peak = 0;
        while(end < n){
            start = end;
            
            //go up
            while(end < n - 1 && arr[end] < arr[end + 1])
                end++;
            
            if(end == start){
                end++;
                continue;
            }
            peak = end;
            
            //go down
            while(end < n - 1 && arr[end] > arr[end + 1])
                end++;
            
            if(end == peak){
                end++;
                continue;
            }
            
            max = Math.max(max, end - start + 1);
            
        }
        return max;
    }
}