class Solution {
    private void fill(int[][] image, int m, int n, int orig, int i, int j, int c){
        if(i >= m || j >= n || i < 0 || j < 0 || image[i][j] == c || image[i][j] != orig)
            return;
        image[i][j] = c;
        int[] dirs = {-1, 0, 1, 0, -1};
        for(int i_ = 0;i_ < 4;i_++)
            fill(image, m, n, orig, i + dirs[i_], j + dirs[i_ + 1], c);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        int m = image.length, n = image[0].length;
        fill(image, m, n, image[sr][sc], sr, sc, color);
        return image;
    }
}