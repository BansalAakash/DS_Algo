class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> dp = new ArrayList();
        dp.add(1);
        for(int i = 1;i <= rowIndex;i++){
            List<Integer> temp = new ArrayList(dp);
            for(int j = 1;j < i;j++)
                temp.set(j, dp.get(j - 1) + dp.get(j));
            temp.add(1);
            dp = temp;
        }
    return dp;
    }
}