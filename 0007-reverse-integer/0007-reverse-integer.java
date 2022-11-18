class Solution {
    public int reverse(int x) {
        int result = 0, sign = x > 0 ? 1 : -1;
        while(x != 0){
            long temp = ((long)result * 10) + ((long)x % 10);
            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
                return 0;
            result = (int)temp;
            x = x/10;
        }
        return result;
    }
}