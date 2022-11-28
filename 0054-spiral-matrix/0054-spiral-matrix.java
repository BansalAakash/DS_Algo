class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int x = matrix.length, y = matrix[0].length, n = x * y, i = 0, k = 0, a = 0, b = 0, flag;
        int right = y - 1, bottom = x - 1, left = 0, top = 1;
        ArrayList<Integer> list = new ArrayList<>();
        int[] dirs = {0, 1, 0, -1, 0};      //right, down, left, up
        while(i < n){
            flag = 1;
            list.add(matrix[a][b]);
          
            if(k == 1 && a == bottom){
                flag = 0;
                bottom--;
            } else if(k == 3 && a == top){
                flag = 0;
                top++;
            } else if(k == 0 && b == right){
                flag = 0;
                right--;
            } else if (k == 2 && b == left){
                flag = 0;
                left++;
            }
            if(flag == 0)
                k = (k + 1) % 4;
            
            a = a + dirs[k];
            b = b + dirs[k + 1];
            i++;
        }
        return list;
    }
}