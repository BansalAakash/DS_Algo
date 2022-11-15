class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0, i_dir = startPos[0] < homePos[0] ? 1 : -1, j_dir = startPos[1] < homePos[1] ? 1 : -1;
        for(int i = startPos[0];i != homePos[0];i += i_dir)
            cost += rowCosts[i + i_dir];
        for(int j = startPos[1];j != homePos[1];j += j_dir)
            cost += colCosts[j + j_dir];
        return cost;
    }
}