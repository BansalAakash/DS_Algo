class Solution {
    public int reverse(int x) {
        int result = 0, sign = x > 0 ? 1 : -1, temp = 0;
        while(x != 0){
            try{
                temp = Math.addExact(Math.multiplyExact(result, 10), (x % 10));
            } catch (Exception e){
                return 0;
            }
            result = temp;
            x = x/10;
        }
        return result;
    }
}