class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length(), i = 0, j = n - 1;
        char ch1 = ' ', ch2 = ' ';
        while(i < j){
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                ch1 = s.charAt(i);
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                ch1 = (char)(s.charAt(i) - 32);
            else{
                i++;
                continue;
            }
            if((s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))
                ch2 = s.charAt(j);
            else if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
                ch2 = (char)(s.charAt(j) - 32);
            else{
                j--;
                continue;
            }
            
            if(ch1 != ch2)
                return false;
            i++;
            j--;
        }
        return true;
    }
}