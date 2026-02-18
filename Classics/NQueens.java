class Solution {
    public void solve(int col, char[][] board, int n, List<List<String>> ans){
        if(col==n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) temp.add(new String(board[i]));
            ans.add(temp);
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(board, row, col,n)){
                board[row][col]= 'Q';
                solve(col+1, board, n, ans);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col, int n){
        //top left diagonal
        //row decreases and col decreases too
        int r= row, c=col;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q') return false;
            r--; c--;
        }
        //bottom left diagonal
        //row increases and col decreases
         r=row; c=col;
        while(r<n && c>=0){
            if(board[r][c]=='Q') return false;
            r++; c--;
        }
        //same row
        //col decreases
         r= row; c=col;
        while(c>=0){
            if(board[r][c]=='Q') return false;
            c--;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n ; j++){
                board[i][j]= '.';
            }
        }
        solve(0,board, n, ans);
        return ans;
    }
}
