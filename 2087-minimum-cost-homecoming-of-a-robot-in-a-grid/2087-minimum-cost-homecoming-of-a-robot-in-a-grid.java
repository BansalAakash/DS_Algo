class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int i = startPos[0], j = startPos[1], i_ = homePos[0], j_ = homePos[1];
        int cost = 0, i_dir = i < i_ ? 1 : -1, j_dir = j < j_ ? 1 : -1;
        while(i != i_ || j != j_){
            if(i != i_){
                i += i_dir;
                cost += rowCosts[i];
            }
            if(j != j_){
                j += j_dir;
                cost += colCosts[j];
            }
        }
        return cost;
    }
}