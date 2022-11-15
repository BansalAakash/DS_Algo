class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] left = new int[n][n], right = new int[n][n], up = new int[n][n], down = new int[n][n];
        int[][] grid = new int[n][n];
        for(int[] row : grid)
            Arrays.fill(row, 1);
        for(int[] ij : mines)
            grid[ij[0]][ij[1]] = 0;
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    left[i][j] = j == 0 ? 1 : (left[i][j - 1] + 1);
                    up[i][j] = i == 0 ? 1 : (up[i - 1][j] + 1);
                }
                if(grid[n - i - 1][j] == 1)
                    down[n - i - 1][j] = i == 0 ? 1 : (down[n - i][j] + 1);
                if(grid[i][n - j - 1] == 1)
                    right[i][n - j - 1] = j == 0 ? 1 : (right[i][n - j] + 1);
            }
        }
        int max = 0;
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                max = Math.max(max, Math.min(Math.min(left[i][j], up[i][j]), Math.min(right[i][j], down[i][j])));
        return max;
    }
}