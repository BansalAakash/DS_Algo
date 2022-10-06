class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length(), i = n - 1, j = 0;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' ') i--;
            while(i >= 0 && s.charAt(i) != ' ')
                str.insert(j, s.charAt(i--));
            str.append(' ');
            j = str.length();
            while(i >= 0 && s.charAt(i) == ' ') i--;
        }
        str.delete(str.length() - 1, str.length());
        return str.toString();
    }
}