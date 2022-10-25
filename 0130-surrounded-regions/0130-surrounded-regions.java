class Solution {
    private static final int[] dirs = {-1, 0, 1, 0, -1};
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = markCorner(board, m, n);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            board[cur[0]][cur[1]] = '_';
            for(int k = 0;k < 4;k++){
                int i = cur[0] + dirs[k], j = cur[1] + dirs[k + 1];
                if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || board[i][j] == '_') continue;
                q.add(new int[] {i,j});
            }
        }
        unMark(board, m, n);
    }
    Queue<int[]> markCorner(char[][] board, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < m;i++){
            if(board[i][0] == 'O')
                q.add(new int[]{i, 0});
            if(board[i][n - 1] == 'O')
                q.add(new int[]{i, n - 1});
        }
        for(int j = 0;j < n;j++){
            if(board[0][j] == 'O')
                q.add(new int[]{0, j});
            if(board[m - 1][j] == 'O')
                q.add(new int[]{m - 1, j});
        }
        return q;
    }
    void unMark(char[][] board, int m, int n){
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '_')
                    board[i][j] = 'O';
            }
        }
    }
}