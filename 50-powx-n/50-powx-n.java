class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n < 0)
            return 1 / x * myPow(1 / x, -1 * (n + 1));
        double result = myPow(x * x, n / 2);
        return n % 2 == 0 ? result : x * result;
    }
}