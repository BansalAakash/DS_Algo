class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        list.add(intervals[0]);
        for(int i = 1;i < n;i++){
            int[] prev = list.get(list.size() - 1), cur = intervals[i];
            if(cur[0] <= prev[1])
                prev[1] = Math.max(prev[1], cur[1]);
            else
                list.add(intervals[i]);
        }
        int n1 = list.size();
        int[][] result = new int[n1][2];
        for(int i = 0;i < n1;i++)
            result[i] = list.get(i);
        return result;
    }
}