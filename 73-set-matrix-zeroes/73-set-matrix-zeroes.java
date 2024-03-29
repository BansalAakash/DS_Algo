class Solution {
    public void setZeroes(int[][] matrix) {
        int firstColMarked = 1;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j == 0)
                        firstColMarked = 0;
                    else
                        matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i < matrix.length;i++){
            for(int j = 1;j < matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(matrix[0][0] == 0){
            for(int j = 0;j < matrix[0].length;j++){
                matrix[0][j] = 0;           //set first row as 0
            }
        }
        if(firstColMarked == 0){
            for(int i = 0;i < matrix.length;i++){
                matrix[i][0] = 0;           //set first col as 0
            }
        }
    }
}