class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int m = image.length, n = image[0].length;
        image[sr][sc] = newColor;
        if(sr > 0 && image[sr - 1][sc] == oldColor && image[sr - 1][sc] != newColor)             //top
            image = floodFill(image, sr - 1, sc, newColor);
        if(sr < m - 1 && image[sr + 1][sc] == oldColor && image[sr + 1][sc] != newColor)         //bottom
            image = floodFill(image, sr + 1, sc, newColor);
        if(sc > 0 && image[sr][sc - 1] == oldColor && image[sr][sc - 1] != newColor)             //left
            image = floodFill(image, sr, sc - 1, newColor);
        if(sc < n - 1 && image[sr][sc + 1] == oldColor && image[sr][sc + 1] != newColor)             //right
            image = floodFill(image, sr, sc + 1, newColor);
        return image;
    }
}