class Solution {
    StringBuilder add(StringBuilder str1, StringBuilder str2){
        int m = str1.length() - 1, n = str2.length() - 1, carry = 0;
        StringBuilder str = new StringBuilder();
        while(m >= 0 || n >= 0){
            int val1 = m >= 0 ? str1.charAt(m) - '0' : 0;
            int val2 = n >= 0 ? str2.charAt(n) - '0' : 0;
            int sum = val1 + val2 + carry;
            str.insert(0, sum % 10);
            carry = sum / 10;
            m--;n--;
        }
        if(carry > 0)
            str.insert(0, carry);
        return str;
    }
    StringBuilder multiplySingle(String s, char ch){
        int m = s.length() - 1, carry = 0, val = ch - '0';
        StringBuilder str = new StringBuilder();
        // System.out.println(s + ", " + val);
        while(m >= 0){
            int sum = (s.charAt(m) - '0') * val + carry;
            carry = sum / 10;
            sum = sum % 10;
            str.insert(0, sum);
            m--;
        }
        if(carry > 0)
            str.insert(0, carry);
        // System.out.println(str.toString());
        return str;
    }
    public String multiply(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        if(m < n) return multiply(num2, num1);
        int shift = 0;
        StringBuilder result = new StringBuilder();
        for(int i = n;i >= 0;i--){
            StringBuilder temp = multiplySingle(num1, num2.charAt(i));
            for(int j = 0;j < shift;j++)
                temp.append('0');
            result = add(result, temp);
            shift++;
        }
        int i = 0;
        while(result.length() > 0 && result.charAt(0) == '0')
            result.deleteCharAt(0);
        String output = result.toString();
        return output.length() > 0 ? output : "0";
    }
}