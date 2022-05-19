class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++)
                if(mat[i][j] == 0)
                    q.add(new int[]{i, j});
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        while(!q.isEmpty()){
            int i = q.peek()[0], j = q.poll()[1];
            res[i][j] = mat[i][j] == 0 ? 0 : res[i][j];
            if(i > 0 && res[i - 1][j] > res[i][j] + 1){                         //top
                res[i - 1][j] = res[i][j] + 1;
                q.add(new int[]{i - 1, j});
            }
            if(i < m - 1 && res[i + 1][j] > res[i][j] + 1){                         //bottom
                res[i + 1][j] = res[i][j] + 1;
                q.add(new int[]{i + 1, j});
            }
            if(j < n - 1 && res[i][j + 1] > res[i][j] + 1){                         //right
                res[i][j + 1] = res[i][j] + 1;
                q.add(new int[]{i, j + 1});
            }
            if(j > 0 && res[i][j - 1] > res[i][j] + 1){                 //left
                res[i][j - 1] = res[i][j] + 1;
                q.add(new int[]{i, j - 1});
            }
        }
        return res;
    }
}