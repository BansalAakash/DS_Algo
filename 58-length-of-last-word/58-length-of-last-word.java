class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length(),i = n - 1;
        while(i >= 0 && s.charAt(i) == ' '){i--;}             //skipping trailing spaces
        if(i < 0) return 0;
        int j = i;
        while(j >= 0 && s.charAt(j) != ' '){j--;}             //find first space from the right (excluding trailing spaces)
        return i - j;
    }
}