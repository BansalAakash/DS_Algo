class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for(int i : bills){
            if(i == 5) five++;
            else if(i == 10){
                if(five > 0) five--;
                else return false;
                ten++;
            } else if(i == 20) {
                if(ten > 0 && five > 0){
                    ten--;five--;
                } else if(five >= 3){
                    five -= 3;
                } else return false;
                twenty++;
            }
        }
        return true;
    }
}