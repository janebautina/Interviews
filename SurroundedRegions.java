class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        int colm = board[0].length;
        if (board == null || row == 0 || colm == 0) {
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == colm - 1 && board[i][j] == 'O') {
                    dfs(board, i , j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm; j++) {
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'Y';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
