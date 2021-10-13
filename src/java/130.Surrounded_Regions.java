class LC130 {
  // O(mn)
  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    // 标记边界上的O为#, 剩下的O为X
    for (int i = 0; i < m; i++) {
      dfs(board, i, 0);
      dfs(board, i, n - 1);
    }
    for (int i = 0; i < n; i++) {
      dfs(board, 0, i);
      dfs(board, m - 1, i);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '#') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void dfs(char[][] board, int x, int y) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
        || board[x][y] != 'O') return;
    board[x][y] = '#';
    dfs(board, x - 1, y);
    dfs(board, x + 1, y);
    dfs(board, x, y - 1);
    dfs(board, x, y + 1);
  }

}