class Solution {
    public int compress(char[] chars) {
        int i = 0, i_ = 0, n = chars.length, j = 0;
        char ch;
        while(i < n){
            i_ = i;
            ch = chars[i++];
            while(i < n && chars[i] == ch) i++;
            chars[j++] = ch;
            int temp = i - i_;
            if(temp <= 1){
                //do nothing
            }else if(temp < 10){
                chars[j++] = (char)(temp + '0');
            } else if(temp < 100){
                chars[j++] = (char)((temp / 10) + '0');
                chars[j++] = (char)((temp % 10) + '0');
            } else if(temp < 1000){
                chars[j++] = (char)((temp / 100) + '0');
                chars[j++] = (char)(((temp / 10) % 10) + '0');
                chars[j++] = (char)((temp % 10) + '0');
            } else{
                chars[j++] = (char)((temp / 1000) + '0');
                chars[j++] = (char)(((temp / 100) % 10) + '0');
                chars[j++] = (char)(((temp / 10) % 10) + '0');
                chars[j++] = (char)((temp % 10) + '0');
            }   
        }
        return j;
    }
}