class LC37 {
  static int N = 9;
  static int n = 3;
  boolean[][] row = new boolean[N][N];
  boolean[][] col = new boolean[N][N];
  boolean[][][] block = new boolean[n][n][N];

  public void solveSudoku(char[][] board) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1';
          row[i][num] = true;
          col[j][num] = true;
          block[i / n][j / n][num] = true;
        }
      }
    }
    solve(board, row, col, block, 0, 0);
  }

  private boolean solve(char[][] board, boolean[][] row, boolean[][] col, boolean[][][] block, int x, int y) {
    if (y == N) {
      x++;
      y = 0;
    }
    if (x == N) return true;
    if (board[x][y] != '.') return solve(board, row, col, block, x, y + 1);
    for (int num = 0; num < N; num++) {
      if (row[x][num] || col[y][num] || block[x / 3][y / 3][num]) {
        continue;
      }
      board[x][y] = (char) (num + '1');
      row[x][num] = true;
      col[y][num] = true;
      block[x / n][y / n][num] = true;
      if (solve(board, row, col, block, x, y + 1)) {
        return true;
      } else {
        //backtrack
        board[x][y] = '.';
        row[x][num] = false;
        col[y][num] = false;
        block[x / n][y / n][num] = false;
      }
    }
    return false;
  }
}