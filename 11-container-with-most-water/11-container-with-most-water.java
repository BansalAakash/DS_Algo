class Solution {
    public int maxArea(int[] h) {
        int max = 0, i = 0, j = h.length - 1;
        while(i < j){
            max = Math.max(max, (j - i) * Math.min(h[j], h[i]));
            if(h[i] < h[j]) i++;
            else j--;
        }
        return max;
    }
}