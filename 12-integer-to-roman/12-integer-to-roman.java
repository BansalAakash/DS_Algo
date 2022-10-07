class Solution {
    public String intToRoman(int n) {
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roms = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder str = new StringBuilder();
        int size = 13, mult = 1;
        while(n > 0){
            for(int i = size - 1;i >= 0;){
                if(n >= nums[i]){
                    str.append(roms[i]);
                    n -= nums[i];
                } else i--;
            }
        }
        return str.toString();
    }
}