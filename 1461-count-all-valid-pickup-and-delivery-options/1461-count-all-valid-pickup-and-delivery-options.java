class Solution {
    private static final int MOD = 1000000007;
    public int countOrders(int n) {
        if(n == 1)
            return 1;
        int result = n * (2 * n - 1);
        return (int)((result * (long)countOrders(n - 1)) % MOD);
    }
}