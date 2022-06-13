class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int i = 0;
        while(income > 0){
            int curSlab = i == 0 ? brackets[i][0] : brackets[i][0] - brackets[i - 1][0];
            tax += Math.min(curSlab, income) * brackets[i][1] / 100.0;
            income -= curSlab;
            i++;
        }
        return tax;
    }
}