class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // System.out.println();
        // for(int[] row : intervals)
        //     System.out.println(Arrays.toString(row));
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
        int[][] result = new int[list.size()][2];
        for(int i = 0;i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}