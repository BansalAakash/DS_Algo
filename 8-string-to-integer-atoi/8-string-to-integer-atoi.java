class Solution {
    int getInt(String s, int i, int j, int sign){
        // System.out.println(i + ", " + j);
        int result = sign * (s.charAt(i++) - '0');
        while(i <= j){

            if(sign * result > (Integer.MAX_VALUE / 10) || (sign * result == (Integer.MAX_VALUE / 10) && (s.charAt(i) - '0') > 7))
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result = (result * 10) + (sign * (s.charAt(i++) - '0'));
            
        }
        return result;
    }
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, start = -1, end = -1;
        
        //ignore leading whitespaces
        while(i < n && s.charAt(i) == ' ') i++;
        
        //check sign bit
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+'))
            sign = s.charAt(i++) == '-' ? -1 : 1;
        
        if(i < n && !Character.isDigit(s.charAt(i))) return 0;
        
        //check if end is reached
        if(i >= n)
            return 0;
        
        //get the segment where digits exist
        start = i;
        while(i < n && Character.isDigit(s.charAt(i))) i++;
        end = i - 1;
        
        return getInt(s, start, end, sign);
    }
}