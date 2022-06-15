class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0, m = A.length, n = B.length;
        List<int[]> list = new ArrayList<>();
        while(i < m && j < n){
            if((B[j][0] <= A[i][1] && A[i][0] <= B[j][1]) || (A[i][0] <= B[j][1] && B[j][0] <= A[i][1]))       //overlap
                list.add(new int[] {Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
            if(A[i][1] < B[j][1])                           //A[i] ends first
                i++;
            else if(A[i][1] > B[j][1])                      //B[j] ends first
                j++;
            else {                                          //Both end at same time
                i++;
                j++;
            }
        }
        int[][] result = new int[list.size()][2];
        for(i = 0;i < list.size();i++)
            result[i] = list.get(i);
        return result;
    }
}