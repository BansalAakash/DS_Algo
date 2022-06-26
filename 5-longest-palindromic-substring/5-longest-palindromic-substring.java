class Solution {
    int len(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i - 1;
    }
    public String longestPalindrome(String s) {
        int left = 0, right = 0, max = 0;
        for(int i = 0;i < s.length();i++){
            int tempOdd = len(s, i, i);
            if(tempOdd > max){
                max = tempOdd;
                left = i - max / 2;
                right = i + max / 2;
            }
            int tempEven = len(s, i, i + 1);
            if(tempEven > max){
                max = tempEven;
                left = i - max / 2 + 1;
                right = i + max / 2;
            }
        }
        return s.substring(left, right + 1);
    }
}