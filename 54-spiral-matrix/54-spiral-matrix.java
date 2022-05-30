class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, count = 0, m = matrix.length, n = matrix[0].length, totalElems = m * n;
        int right = n - 1, bottom = m - 1, left = 0, top = 1, direction = 0;       
        //0:right, 1:bottom, 2:left, 3:top
        List<Integer> result = new ArrayList<Integer>();
        while(count++ < totalElems){
            result.add(matrix[i][j]);
            if(j == right && direction == 0){
                direction++;
                right--;
            } else if(i == bottom && direction == 1){
                direction++;
                bottom--;
            } else if(j == left && direction == 2){
                direction++;
                left++;
            } else if(i == top && direction == 3){
                direction = 0;
                top++;
            }
            
            if(direction == 0){
                j++;
            } else if(direction == 1){
                i++;
            } else if(direction == 2){
                j--;
            } else{
                i--;
            }
        }
        return result;
    }
}