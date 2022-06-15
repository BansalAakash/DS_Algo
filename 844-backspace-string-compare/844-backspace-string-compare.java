class Solution {
    String transform(String s){
        StringBuilder str = new StringBuilder(s);
        int n = s.length();
        for(int i = 0;i < n;i++){
            if(str.charAt(i) == '#'){
                int j = i - 1;
                while(j >= 0 && (str.charAt(j) == '*' || str.charAt(j) == '#'))
                    j--;
                if(j >= 0)
                    str.setCharAt(j, '*');
            }
        }
        String result = str.toString();
        result = result.replaceAll("\\*", "");
        result = result.replaceAll("#", "");
        return result; 
    }
    public boolean backspaceCompare(String s, String t) {
        s = transform(s);
        t = transform(t);
        System.out.println(s + " " + t);
        return s.equals(t);
    }
}