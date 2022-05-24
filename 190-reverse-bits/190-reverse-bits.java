public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0, count = 32;
        while(n != 0){
            result = result << 1;
            result = result | (n & 1);
            n = n >>> 1;
            count--;
        }
        result = result << count;
        return result;
    }
}