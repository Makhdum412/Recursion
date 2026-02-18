class Solution {
    public boolean isSafe(char[][] board, int row, int col, char value){
        for(int i=0; i<9; i++){
            // same row
           if(board[row][i]==value) return false;
           if(board[i][col]== value) return false;
           int boxrow=3*(row/3)+ i/3;
           int boxcol=3*(col/3)+ i%3;
           if(board[boxrow][boxcol]==value) return false;
        }
        return true;
    }
    public boolean solve(char[][] board){
        for(int row=0; row< board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(board[row][col]=='.'){
                    for(char value='1'; value<='9'; value++){
                        if(isSafe(board, row, col, value)){
                        board[row][col]=value;
                        if(solve(board))
                        return true;
                        board[row][col]='.';
                    }
                }
                    return false;
            }
           
        }
    }
     return true;
 }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
