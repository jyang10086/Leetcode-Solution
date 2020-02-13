package Design;

class NumMatrix {
    private int[][] numMatrix;
    //Solution One

    public NumMatrix(int[][] matrix) {
        this.numMatrix = matrix.clone();
    }

    public void update(int row, int col, int val) {
        this.numMatrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; ++i) {
            for (int j = col1; j <= col2; ++j) {
                sum += numMatrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix nm = new NumMatrix(matrix);
        int a1 = nm.sumRegion(2, 1, 4, 3);
        System.out.println("a1: " + a1);
        nm.update(3, 2, 2);
        int a2 = nm.sumRegion(2, 1, 4, 3);
        System.out.println("a2 " + a2);

    }
}


