class Solution {
    int sumDivisors(int n){
        int sum = 1;
        for(int i = 2;i * i <= n;i++)
            if(n % i == 0)
                sum += i + (n / i);
        return sum;
    }
    public boolean checkPerfectNumber(int num) {
        return num > 2 && num == sumDivisors(num);
    }
}