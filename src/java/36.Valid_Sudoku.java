class LC36 {
  static int N = 9;
  static int n = 3;

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < N; i++) {
      boolean[] row = new boolean[N];
      for (int j = 0; j < N; j++) {
        if (board[i][j] == '.') continue;
        int num = board[i][j] - '1';
        if (row[num]) return false;
        row[num] = true;
      }
    }
    for (int i = 0; i < N; i++) {
      boolean[] col = new boolean[N];
      for (int j = 0; j < N; j++) {
        if (board[j][i] == '.') continue;
        int num = board[j][i] - '1';
        if (col[num]) return false;
        col[num] = true;
      }
    }
    /***
     0,0  0,3  0,6
     2,2  5,5  8,8
     */
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isValidBox(board, i * 3, j * 3, (i + 1) * 3, (j + 1) * 3)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValidBox(char[][] board, int a, int b, int m, int n) {
    boolean[] box = new boolean[N];
    for (int i = a; i < m; i++) {
      for (int j = b; j < n; j++) {
        if (board[i][j] == '.') continue;
        int num = board[i][j] - '1';
        if (box[num]) return false;
        box[num] = true;
      }
    }
    return true;
  }
}