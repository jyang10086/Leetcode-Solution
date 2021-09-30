class LC54 {
  /**
   * 顺时针输出矩阵
   * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * Output: [1,2,3,6,9,8,7,4,5]
   * */
  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    List<Integer> result = new ArrayList<>();
    int up = 0, down = m - 1, left = 0, right = n - 1;
    while(true) {
      for(int i = left; i <= right; i ++) {
        result.add(matrix[up][i]);
      }
      up++;
      if(up > down) break;
      for(int i = up; i <= down; i ++) {
        result.add(matrix[i][right]);
      }
      right--;
      if(right < left) break;
      for(int i = right; i >= left; i--) {
        result.add(matrix[down][i]);
      }
      down--;
      if(down < up) break;
      for(int i = down; i >= up; i--) {
        result.add(matrix[i][left]);
      }
      left++;
      if(left > right) break;
    }
    return result;
  }
}