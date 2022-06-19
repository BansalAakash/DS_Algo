class Solution {
    void mark(char[][] board, int i, int j, int m, int n, boolean[][] visited){
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == 'X' || visited[i][j])
            return;
        board[i][j] = '1';
        visited[i][j] = true;
        int[] dirs = {-1, 0, 1, 0, -1};
        for(int k = 0;k < 4;k++)
            mark(board, i + dirs[k], j + dirs[k + 1], m, n, visited);
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;i++)
            mark(board, i, 0, m, n, visited);   //first col
        for(int i = 0;i < m;i++)
            mark(board, i, n - 1, m, n, visited);   //last col
        for(int i = 0;i < n;i++)
            mark(board, 0, i, m, n, visited);       //first row
        for(int i = 0;i < n;i++)
            mark(board, m - 1, i, m, n, visited);   //last row
        
        
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '1')
                    board[i][j] = 'O';
    }
}