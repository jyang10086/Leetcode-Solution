import java.util.ArrayList;
import java.util.List;

public class NumDistinctIslands2 {
    //  Count the number of distinct islands. (including rotated)
    public int numDistinctIslands2(int[][] grid) {
        List<int[]> islands = new ArrayList();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    getIslandsByDfs(i, j, grid, islands);
                }
            }
        }
        return -1;
    }

    private void getIslandsByDfs(int row, int col, int[][] grid, List<int[]> islands) {
        int m = grid.length;
        int n = grid[0].length;
        if (row >= m && col >= n && row < 0 && col < 0 && grid[row][col] <= 0) return;
        grid[row][col] = -1;
        islands.add(new int[]{row, col});
        int[][] directions = {{-1, 0}, {1, 0}, {1, 0}, {0, -1}};
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[0];
            getIslandsByDfs(nextRow, nextCol, grid, islands);
        }
    }
}
