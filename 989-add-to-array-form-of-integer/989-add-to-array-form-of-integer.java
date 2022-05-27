class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int n = num.length - 1, carry = 0;
        while(k != 0 || n >= 0){
            int temp = carry;
            if(n >= 0) temp += num[n--];
            temp += k % 10;
            result.add(0, temp % 10);
            carry = temp / 10;
            k = k / 10;
        }
        if(carry > 0) result.add(0, carry);
        return result;
    }
}