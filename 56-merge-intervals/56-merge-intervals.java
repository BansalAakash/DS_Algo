class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        int n = intervals.length;
        list.add(intervals[0]);
        for(int i = 1;i < n;i++){
            if(intervals[i][0] <= list.get(list.size() - 1)[1]){
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}