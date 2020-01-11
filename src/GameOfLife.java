import java.util.Arrays;

public class GameOfLife {

    private final int dieTolive = 2;
    private final int liveTodie = 3;

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cnt = countLive(i, j, board);
                if (board[i][j] == 1) {
                    if (cnt != 2 && cnt != 3) {
                        board[i][j] = liveTodie;
                    }
                } else if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = dieTolive;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == dieTolive) {
                    board[i][j] = 1;
                } else if (board[i][j] == liveTodie) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLive(int i, int j, int[][] board) {
        int cnt = 0;
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                if (board[x][y] == 1 || board[x][y] == liveTodie)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();
        int[][] t = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        g.gameOfLife(t);
        Arrays.stream(t).forEach(
                arr -> {
                    Arrays.stream(arr).forEach(
                            val -> System.out.print(val + " ")
                    );
                    System.out.println();
                }
        );
    }
}
