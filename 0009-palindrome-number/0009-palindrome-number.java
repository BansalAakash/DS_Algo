class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int digits = 0, temp = x;
        while(temp != 0){
            temp = temp / 10;
            digits++;
        }
        for(int i = 0;i < digits / 2;i++){
            int dig1 = (x / (int)Math.pow(10, i)) % 10;
            int dig2 = x / (int)Math.pow(10, (digits - i - 1)) % 10;
            if(dig1 != dig2)
                return false;
        }
        return true;
    }
}