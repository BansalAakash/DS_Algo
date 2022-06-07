class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0, sum = 0;
        StringBuilder str = new StringBuilder();
        while(m >= 0 || n >= 0){
            int val1 = m >= 0 ? num1.charAt(m) - '0' : 0;
            int val2 = n >= 0 ? num2.charAt(n) - '0' : 0;
            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            str.insert(0, sum);
            m--;n--;
        }
        if(carry > 0)
            str.insert(0, carry);
        return str.toString();
    }
}