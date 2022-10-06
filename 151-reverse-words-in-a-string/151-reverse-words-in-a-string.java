class Solution {
    void reverseString(int i, int j, char[] ch){
        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = 0, n = s.length();
        //clean spaces - j remains ahead
        while(j < n){
            while(j < n && ch[j] == ' ') j++;
            while(j < n && ch[j] != ' ') ch[i++] = ch[j++];
            while(j < n && ch[j] == ' ') j++;
            if(j < n) ch[i++] = ' ';
        }
        //i is at 1 + last index of the string without trailing spaces
        n = i - 1;
        // System.out.println("After cleaning spaces ; " + Arrays.toString(ch));
        
        //reverse whole string
        reverseString(0, n, ch);
        // System.out.println("After reversing whole ; " + Arrays.toString(ch));
        
        
        //reverse individual words within string
        i = 0;
        j = 0;
        while(j <= n){
            while(j <= n && ch[j] != ' ')j++;
            reverseString(i, j - 1, ch);
            j++;
            i = j;
        }
        return new String(ch, 0, n + 1);
    }
}