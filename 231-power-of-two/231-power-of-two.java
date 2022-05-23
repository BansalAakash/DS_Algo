class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n != 0) && ((n >> 31) == 0) && ((n & (n - 1)) == 0);
    }
}