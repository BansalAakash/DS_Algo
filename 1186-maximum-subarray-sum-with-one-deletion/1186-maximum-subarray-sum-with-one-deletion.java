class Solution {
    public int maximumSum(int[] arr) {
        if(arr.length == 1) return arr[0];
        int d = 0, nd = arr[0], temp_d = 0, temp_nd = 0, max = Integer.MIN_VALUE;
        for(int i = 1;i < arr.length;i++){
            temp_nd = arr[i] + Math.max(0, nd);
            temp_d = Math.max(d + arr[i], nd);
            d = temp_d;
            nd = temp_nd;
            max = Math.max(max, Math.max(d, nd));
        }
        return max;
    }
}