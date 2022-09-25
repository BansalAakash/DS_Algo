class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if(n == 1)
            return arr[0];
        int left[] = new int[n], right[] = new int[n];
        
        for(int i = 1;i < n;i++){
            left[i] = arr[i - 1] + Math.max(0, left[i - 1]);                //left subarray ending at i - 1
            right[n - i - 1] = arr[n - i] + Math.max(0, right[n - i]);  //right subarray ending at i + 1
        }
        int max = right[0] + Math.max(0, arr[0]);           //for first elem only consider right subarray
        for(int i = 1;i < n - 1;i++){                        //go from second to last second elem
            int temp = Math.max(0, arr[i]);
            max = Math.max(max, Math.max(left[i] + right[i] + temp, Math.max(left[i] + temp, right[i] + temp)));
            
        }
        max = Math.max(max, left[n - 1] + Math.max(0, arr[n - 1]));//for last elem only consider left subarray
        return max;
    }
}