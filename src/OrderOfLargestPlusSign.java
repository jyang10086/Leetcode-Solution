import java.util.Arrays;

public class OrderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] map = new int[N][N];
        for (int[] m : map) {
            Arrays.fill(m, N);
        }
        for (int[] mine : mines) {
            int x = mine[0];
            int y = mine[1];
            map[x][y] = 0; // mine = 0
        }
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                l = map[i][j] == 0 ? 0 : l + 1;
                r = map[i][k] == 0 ? 0 : r + 1;
                u = map[j][i] == 0 ? 0 : u + 1;
                d = map[k][i] == 0 ? 0 : d + 1;
                map[i][j] = Math.min(map[i][j], l);
                map[i][k] = Math.min(map[i][k], r);
                map[j][i] = Math.min(map[j][i], u);
                map[k][i] = Math.min(map[k][i], d);
            }
            System.out.println();
            for (int[] m : map) {
                System.out.println(Arrays.toString(m));
            }
        }
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, map[i][j]);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        OrderOfLargestPlusSign olp = new OrderOfLargestPlusSign();
        int ans = olp.orderOfLargestPlusSign(5, new int[][]{{4, 2}});
        System.out.println(ans);
    }
}
