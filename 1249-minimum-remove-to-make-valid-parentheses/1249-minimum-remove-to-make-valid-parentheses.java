class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        int n = s.length();
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    str.setCharAt(i, '*');
                else stack.pop();
            }
        }
        while(!stack.isEmpty())
            str.setCharAt(stack.pop(), '*');
        return str.toString().replaceAll("\\*", "");
    }
}