class Solution {
    boolean solve(char[][] board, int i, int j, int m, int n, String word, int pos, boolean[][] visited){
        if(pos == word.length())
            return true;
        if(i < 0 || j < 0 || i == m || j == n || visited[i][j] || board[i][j] != word.charAt(pos))
            return false;
        visited[i][j] = true;
        int[] dirs = {-1, 0, 1, 0, -1};
        for(int k = 0;k < 4;k++)
            if(solve(board, i + dirs[k], j + dirs[k + 1], m, n, word, pos + 1, visited))
                return true;
        visited[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                if(solve(board, i, j, m, n, word, 0, new boolean[m][n]))
                    return true;
        return false;
    }
}