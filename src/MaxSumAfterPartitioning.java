import java.util.Arrays;

public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int max = A[i];
            for (int j = 1; j <= K; j++) {
                if (i - j + 1 >= 0) {
                    max = Math.max(max, A[i - j + 1]);
                    int val = i >= j ? dp[i - j] : 0;
                    dp[i] = Math.max(dp[i], val + max * j);
                    System.out.println("K:" + j + " dp[" + i + "]:" + dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }

    public static void main(String[] args) {
        MaxSumAfterPartitioning msap = new MaxSumAfterPartitioning();
        int[] A = {1, 15, 7, 9, 2, 5, 10};
        System.out.println(msap.maxSumAfterPartitioning(A, 3));
    }
}
