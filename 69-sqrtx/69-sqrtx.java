class Solution {
    public int mySqrt(int x) {
        if(x == 0) return x;
        if(x < 4)
            return 1;
        int low = 0, high = Integer.MAX_VALUE, mid = -1;
        while(true){
            mid = low + (high - low) / 2;
            if(mid > x / mid)
                high = mid - 1;
            else {
                if(mid == x / mid || (mid + 1) > x / (mid + 1)) return mid;
                else low = mid + 1;
            }
        }
    }
}