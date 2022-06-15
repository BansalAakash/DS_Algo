class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0, m = A.length, n = B.length;
        List<int[]> list = new ArrayList<>();
        while(i < m && j < n){
            if(Math.max(A[i][0], B[j][0]) <= Math.min(A[i][1], B[j][1]))       //overlap
                list.add(new int[] {Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
            if(A[i][1] < B[j][1])                           //A[i] ends first
                i++;
            else
                j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}