class LC840 {
  /**
   * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9
   * such that each row, column, and both diagonals all have the same sum.
   *
   * Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there? 
   * (Each subgrid is contiguous).
   *
   *
   *
   * */
  static int n = 3;
  // O(m*n*K)
  public int numMagicSquaresInside(int[][] grid) {
    int cnt = 0;
    for (int i = 0; i + n <= grid.length; i++) {
      for (int j = 0; j + n <= grid[0].length; j++ ) {
        if (isValidSquare(grid, i, j)) {
          cnt++;
        }
      }
    }
    return cnt;
  }
  private boolean isValidSquare(int[][] grid, int x, int y) {
    int[] record = new int[10];
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]] != 0) {
          return false;
        }
        record[grid[i][j]] = grid[i][j];
      }
    }
    int leftDiagonal = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
    int rightDiagonal = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];
    if (leftDiagonal != rightDiagonal) {
      return false;
    }
    for (int i = 0; i < n; i++) {
      int rowSum = grid[x + i][y] + grid[x + i][y + 1] + grid[x + i][y + 2];
      if (rowSum != leftDiagonal) {
        return false;
      }
      int colSum = grid[x][y + i] + grid[x + 1][y + i] + grid[x + 2][y + i];
      if (colSum != rightDiagonal) {
        return false;
      }
    }
    return true;
  }
}