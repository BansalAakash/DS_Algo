class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length(), carry = 0;
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < Math.max(m, n);i++){
            int val1 = i < m ? a.charAt(m - i - 1) - '0' : 0;
            int val2 = i < n ? b.charAt(n - i - 1) - '0' : 0;
            int temp = val1 + val2 + carry;
            builder.insert(0, temp & 1);
            carry = temp >> 1;
        }
        if(carry == 1) builder.insert(0, 1);
        return builder.toString();
    }
}