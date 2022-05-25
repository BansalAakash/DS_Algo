class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, j = n - 1;
        while(j >= 0 && digits[j] == 9)
            j--;
        if(j >= 0){
            digits[j] += 1;j++;
            while(j < n && digits[j] == 9) digits[j++] = 0;
            return digits;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}