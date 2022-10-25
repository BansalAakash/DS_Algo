import java.util.*;
class UnionD{
    int[] parent, rank;
    int m, n;
    public UnionD(char[][] grid){
        m = grid.length;
        n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for(int i = 0;i < m * n;i++)
            parent[i] = i;
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 'O')
                    rank[i * n + j] = Integer.MAX_VALUE;
    }
    int findParent(int i, int j){
        int x = i * n + j;
        return findParentHelper(x);
    }
    int findParentHelper(int x){
        if(parent[x] == x)
            return x;
        parent[x] = findParentHelper(parent[x]);
        return parent[x];
    }
    void union(int i, int j, int x, int y){
        int par1 = findParent(i, j), par2 = findParent(x, y);
        if(par1 != par2)
            union(par1, par2);
    }
    void union(int a, int b){
        if(rank[a] < rank[b])
            parent[a] = b;
        else if(rank[b] < rank[a])
            parent[b] = a;
        else{                               //doesn't matter who is who's parent if rank is same
            parent[a] = b;
            if(rank[b] != Integer.MAX_VALUE)
                rank[b]++;
        }
    }
}
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if(m < 1 || n < 1)
            return;
        
        Solution s = new Solution();
        int[] dirs = {-1, 0, 1, 0, -1};

        UnionD ud = new UnionD(board);
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 'X') continue;
                for(int k = 0;k < 4;k++){
                    int x = i + dirs[k], y = j + dirs[k + 1];
                    if(x >= 0 && y >= 0 && x < m && y < n && board[x][y] != 'X')
                        ud.union(i, j, x, y);
                }
            }
        }

        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++){
                int val = ud.findParent(i, j), x = val / n, y = val % n;
                if(x != 0 && y != 0 && x != m - 1 && y != n - 1)
                    board[i][j] = 'X';
            }
    }
}