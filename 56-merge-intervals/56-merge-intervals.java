class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int j = 0, n = intervals.length;
        
        while(j < n){
            int flag = 0;
            for(int i = 0;i < list.size();i++){
                if((intervals[j][0] >= list.get(i)[0] && intervals[j][0] <= list.get(i)[1]) || (intervals[j][1] >= list.get(i)[0] && intervals[j][1] <= list.get(i)[1])){
                    int min = Math.min(intervals[j][0], list.get(i)[0]);
                    int max = Math.max(intervals[j][1], list.get(i)[1]);
                    list.set(i, new int[]{min, max});
                    flag = 1;
                }
            }
            if(flag == 0)
                list.add(new int[]{intervals[j][0], intervals[j][1]});
            j++;
        }
        int[][] result = new int[list.size()][2];
        for(int i = 0;i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}