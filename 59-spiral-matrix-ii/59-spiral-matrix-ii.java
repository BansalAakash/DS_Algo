class Solution {
    public int[][] generateMatrix(int n) {
        int count = 0, i = 0, j = 0, direction = 0; //0,1,2,3 -> right, down, left, up
        int[][] A = new int[n][n];
        int right = n - 1, bottom = n - 1, left = 0, top = 1;       //boundaries
        while(count++ < n * n) {
            A[i][j] = count;
            System.out.println(i + " " + j);
            switch (direction){
                case 0:                                 //right
                    if(j == right){
                        direction++;
                        right--;
                        i++;
                    }
                    else
                        j++;
                    break;
                case 1:                                 //down
                    if(i == bottom){
                        direction++;
                        bottom--;
                        j--;
                    }
                    else
                        i++;
                    break;
                case 2:                                 //left
                    if(j == left){
                        direction++;
                        left++;
                        i--;
                    }
                    else
                        j--;
                    break;
                case 3:                                 //up
                    if(i == top){
                        direction = 0;
                        top++;
                        j++;
                    }
                    else
                        i--;
                    break;
                default:
                    throw new IllegalStateException("Where you going?");
            }
        }
        return A;
    }
}