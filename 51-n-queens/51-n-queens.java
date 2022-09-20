class Solution {
    boolean isValidStep(char[][] board, int n, int i_, int j_){
        for(int i = i_;i>=0;i--)
            if(board[i][j_] == 'Q')
                return false;
        for(int j = j_;j>=0;j--)
            if(board[i_][j] == 'Q')
                return false;
        for(int i = i_, j = j_;i >= 0 && j >= 0;i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }
        for(int i = i_, j = j_;i >= 0 && j < n;i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    void solve(List<List<String>> result, char[][] board, int index, int n){
        if(index == n){
            List<String> cur = new ArrayList<>();
            for(char[] ch : board)
                cur.add(new String(ch));
            result.add(cur);
            return;
        }
        for(int j = 0;j < n;j++){
            if(isValidStep(board, n, index, j)){
                board[index][j] = 'Q';
                solve(result, board, index + 1, n);
                board[index][j] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] ch : board)
            Arrays.fill(ch, '.');
        solve(result, board, 0, n);
        return result;
    }
}