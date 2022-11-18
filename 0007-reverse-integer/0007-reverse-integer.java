class Solution {
    public int reverse(int x) {
        int result = 0, MAX = Integer.MAX_VALUE / 10, MIN = Integer.MIN_VALUE / 10;
        while(x != 0){
            if(result > MAX || (result == MAX & (x % 10 > 7)))
                return 0;
            if(result < MIN || (result == MIN & (x % 10 > 7)))
                return 0;
            result = (result * 10) + (x % 10);
            x = x/10;
        }
        return result;
    }
}