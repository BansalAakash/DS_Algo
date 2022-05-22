class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if(m == 1) return triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < triangle.size();i++){
            List<Integer> prevList = triangle.get(i - 1);
            List<Integer> curList = triangle.get(i);
            int n = curList.size();
            curList.set(0, curList.get(0) + prevList.get(0));
            curList.set(n - 1, curList.get(n - 1) + prevList.get(n - 2));
            min = Math.min(curList.get(0), curList.get(n - 1));
            for(int j = 1;j < n - 1;j++){
                curList.set(j, curList.get(j) + Math.min(prevList.get(j - 1), prevList.get(j)));
                min = Math.min(min, curList.get(j));
            }
        }
        return min;
    }
}