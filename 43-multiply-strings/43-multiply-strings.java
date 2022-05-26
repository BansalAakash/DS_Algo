class Solution {
    ArrayList<Integer> multiply(ArrayList<Integer> list, int num){
        ArrayList<Integer> result = new ArrayList<>();
        int n = list.size(), carry = 0;
        for(int i = n - 1;i >= 0;i--){
            int temp = list.get(i) * num + carry;
            result.add(0, temp % 10);
            carry = temp / 10;
        }
        if(carry > 0) result.add(0, carry);
        return result;
    }
    ArrayList<Integer> add(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int m = list1.size(), n = list2.size(), carry = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i < Math.max(m, n);i++){
            int val1 = i < m ? list1.get(m - i - 1) : 0;
            int val2 = i < n ? list2.get(n - i - 1) : 0;
            int temp = val1 + val2 + carry;
            result.add(0, temp % 10);
            carry = temp / 10;
        }
        if(carry > 0) result.add(0, carry);
        return result;
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        if(m < n) return multiply(num2, num1);
        ArrayList<Integer> num1_list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(char ch : num1.toCharArray()) num1_list.add(ch - '0');
        int shift = 0;
        for(int i = n - 1;i >= 0;i--){
            ArrayList<Integer> temp = multiply(num1_list, num2.charAt(i) - '0');
            for(int j = 0;j < shift;j++)
                temp.add(0);
            result = add(result, temp);
            shift++;
        }
        StringBuilder builder = new StringBuilder();
        for(int i : result)
            builder.append(i);
        return builder.toString();
    }
}