class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int size = s.length();
        for(int i = 1;i <= size / 2;i++){
            if(size % i == 0){
                String result = "", sub = s.substring(0, i);
                int j = size / i;
                while(j-- > 0) result += sub;
                if(s.compareTo(result) == 0) return true;
            }
        }
        return false;
    }
}