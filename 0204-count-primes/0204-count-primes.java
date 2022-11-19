class Solution {
    public int countPrimes(int n) {
        if(n < 2)
            return 0;
        boolean[] dp = new boolean[n + 1];
        int count = 0;
        for(int i = 2;i * i <= n;i++)
            if(!dp[i]){
                for(int j = i * i;j <= n; j += i)
                    dp[j] = true;
            }
        for(int i = 2;i < n;i++)
            if(!dp[i])
                count++;
        return count;
    }
}