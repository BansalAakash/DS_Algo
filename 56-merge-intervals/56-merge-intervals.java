class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int count = 0, end = intervals[0][1];
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
                result.get(count)[1] = end;
            }
            else{
                count++;
                result.add(intervals[i]);
                end = intervals[i][1];
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}