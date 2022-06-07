class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        int len = 0, flag = 0;
        for(char ch : s.toCharArray())
            freq[(int)ch]++;
        for(int i = 0;i < 128;i++){
            if((freq[i] & 1) == 0) len += freq[i];
            else {
                flag = 1;
                len += freq[i] - 1;
            }
        }
        return len + flag;
    }
}