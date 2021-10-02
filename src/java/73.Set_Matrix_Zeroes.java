class LC73 {
  public void setZeroes(int[][] matrix) {
    int row = matrix.length, col = matrix[0].length;
    boolean row0 = false, col0 = false;
    // first column
    for(int i = 0 ; i < row; i++) {
      if(matrix[i][0] == 0) {
        col0 = true;
      }
    }
    // first row
    for(int i = 0 ; i < col; i++) {
      if(matrix[0][i] == 0) {
        row0 = true;
      }
    }
    for(int i = 1 ; i < row; i++) {
      for(int j = 1 ; j < col; j++) {
        if(matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for(int i = 1 ; i < row; i++) {
      if(matrix[i][0] == 0) {
        for(int j = 1 ; j < col; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for(int j = 1 ; j < col; j++) {
      if(matrix[0][j] == 0) {
        for(int i = 1 ; i < row; i++) {
          matrix[i][j] = 0;
        }
      }
    }

    if(row0) {
      for(int j = 0; j < col; j ++) {
        matrix[0][j] = 0;
      }
    }

    if(col0) {
      for(int i = 0; i < row; i++) {
        matrix[i][0] = 0;
      }
    }

  }
}