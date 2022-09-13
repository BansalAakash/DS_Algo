class Solution {
    public int trap(int[] h) {
        int n = h.length;
        if(n < 3)
            return 0;
        int result = 0, lm = 0, rm = 0, l = 0, r = n - 1;       //lm = leftMax, rm = rightMax
        while(l < r){
            if(h[l] < h[r]){
                lm = Math.max(lm, h[l]);
                result += lm > h[l] ? lm - h[l] : 0;
                l++;
            } else {
                rm = Math.max(rm, h[r]);
                result += rm > h[r] ? rm - h[r] : 0;
                r--;
            }
        }
        return result;
    }
}