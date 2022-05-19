class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length, countFresh = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 2) 
                    q.add(new int[] {i, j});
                else if(grid[i][j] == 1) countFresh++;
            }
        }
        if(countFresh == 0) return 0;
        int mins = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size(), count = 0, foundSomething = 0;
            // display(q);
            while(count++ < size){
                int row = q.peek()[0], col = q.poll()[1];
                for(int i = 0;i < 4;i++){
                    int newRow = row + dir[i][0], newCol = col + dir[i][1];
                    if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                        foundSomething = 1;
                        countFresh--;
                    }
                }
            }
            if(foundSomething == 1) mins++;
        }
        return countFresh == 0 ? mins : -1;
    }
}