class Solution {
    int checkPalindrome(String s, int x, int y, int n){
        if(y >= n) return 0;
        while(x >= 0 && y < n && s.charAt(x) == s.charAt(y)){x--;y++;}
        return y - x - 1;
    }
    public String longestPalindrome(String s) {
        int n = s.length(), max = 0, start = 0, end = 0;
        for(int i = 0;i < n;i++){
            int x = checkPalindrome(s, i, i, n), y = checkPalindrome(s, i, i + 1, n);
            // System.out.println("i : " + i + ", x : " + x + ", y : " + y);
            if(x > max){
                max = x;
                start = i - x / 2;
                end = i + x / 2;
            }
            if(y > max){
                max = y;
                start = i - (y / 2 - 1);
                end = i + 1 + (y / 2 - 1);
            }
        }
        return s.substring(start, end + 1);
    }
}