class Solution {
    public String intToRoman(int n) {
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roms = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int len = nums.length - 1;
        StringBuilder str = new StringBuilder();
        int size = 13, mult = 1;
        while(n > 0){
            int cur = (n % 10) * mult;
            mult *= 10;
            n /= 10;
            StringBuilder temp = new StringBuilder();
            for(int i = len;i >= 0;){
                if(cur >= nums[i]){
                    temp.append(roms[i]);
                    cur -= nums[i];
                } else i--;
            }
            str.insert(0, temp);
        }
        
        return str.toString();
    }
}