class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][0] <= result.get(result.size() - 1)[1])        //overlap
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            else                                                                    //No overlap
                result.add(intervals[i]);
        }
        return result.toArray(new int[result.size()][]);
    }
}