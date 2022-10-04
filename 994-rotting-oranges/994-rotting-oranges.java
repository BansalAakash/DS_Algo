class Solution {
    class Node{
        int i, j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    int mark(int[][] grid, boolean[][] visited, Queue<Node> rotten, int countFresh){
        int mins = 0, m = grid.length, n = grid[0].length;
        while(!rotten.isEmpty()){
            int size = rotten.size();
            boolean flag = false;
            while(size-- > 0){
                Node temp = rotten.poll();
                int i = temp.i, j = temp.j;
                visited[i][j] = true;
                int[] dirs = {0, -1, 0, 1, 0};
                for(int x = 0;x < 4;x++){
                    int x_ = i + dirs[x], y_ = j + dirs[x + 1];
                    if(x_ < 0 || y_ < 0 || x_ >= m || y_ >= n || grid[x_][y_] != 1 || visited[x_][y_])
                        continue;
                    flag = true;
                    visited[x_][y_] = true;
                    countFresh--;
                    grid[x_][y_] = 2;
                    rotten.add(new Node(x_, y_));
                }
            }
            if(flag)
                mins++;
            // System.out.println("Minutes : " + mins);
            // display(grid);
            // displayQueue(rotten);
        }
        return countFresh > 0 ? -1 : mins;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                if(grid[i][j] == 2)
                    q.add(new Node(i, j));
                else if(grid[i][j] == 1)
                    countFresh++;
        return mark(grid, visited, q, countFresh);
    }
}