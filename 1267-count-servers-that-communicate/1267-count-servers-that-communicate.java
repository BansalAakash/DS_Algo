class Solution {
    public int countServers(int[][] grid) {
        HashMap<Integer, Integer> rows = new HashMap<>(), cols = new HashMap<>();
        for(int i = 0;i < grid.length;i++)
            for(int j = 0;j < grid[0].length;j++)
                if(grid[i][j] == 1){
                    rows.put(i, rows.getOrDefault(i, 0) + 1);
                    cols.put(j, cols.getOrDefault(j, 0) + 1);
                }
        int result = 0;
        for(int i = 0;i < grid.length;i++)
            for(int j = 0;j < grid[0].length;j++)
                if(grid[i][j] == 1 && (rows.get(i) > 1 || cols.get(j) > 1))
                    result++;
        return result;
    }
}