class Solution {
    boolean solve(char[][] board, int x, int y, ArrayList<HashSet<Character>> rows, ArrayList<HashSet<Character>> cols, ArrayList<HashSet<Character>> boxes){
        if(y == 9) return true;
        else if(x == 9)
            return solve(board, 0, y + 1, rows, cols, boxes);
        else if(board[x][y] != '.')
            return solve(board, x + 1, y, rows, cols, boxes);
        for(int i = 1;i <= 9;i++){
            char ch = (char)(i + '0');
            if(!rows.get(x).contains(ch) && !cols.get(y).contains(ch) && !boxes.get((3 * (x/3)) + (y/3)).contains(ch)){
                board[x][y] = ch;
                rows.get(x).add(ch);
                cols.get(y).add(ch);
                boxes.get((3 * (x/3)) + (y/3)).add(ch);
                if(solve(board, x + 1, y, rows, cols, boxes)) return true;
                board[x][y] = '.';
                rows.get(x).remove(ch);
                cols.get(y).remove(ch);
                boxes.get((3 * (x/3)) + (y/3)).remove(ch);
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rows = new ArrayList<>();
        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        ArrayList<HashSet<Character>> boxes = new ArrayList<>();
        for(int i = 0;i < 9;i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.') continue;
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                boxes.get((3 * (i/3)) + (j/3)).add(board[i][j]);
            }
        }
        solve(board, 0, 0, rows, cols, boxes);
    }
}