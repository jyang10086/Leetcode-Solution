import java.util.Arrays;

class LC322 {
  /**
   * 322. Coin Change
   * <p>
   * You are given an integer array coins representing coins of different denominations
   * and an integer amount representing a total amount of money.
   * <p>
   * Return the fewest number of coins that you need to make up that amount.
   * If that amount of money cannot be made up by any combination of the coins, return -1.
   * <p>
   * You may assume that you have an infinite number of each kind of coin.
   * <p>
   * Example 1:
   * <p>
   * Input: coins = [1,2,5], amount = 11
   * Output: 3
   * Explanation: 11 = 5 + 5 + 1
   * <p>
   * Example 2:
   * <p>
   * Input: coins = [2], amount = 3
   * Output: -1
   */
  public int coinChange(int[] coins, int amount) {
    /*
     * dp: cnt
     * for per coin
     *  dp[i] = Min(dp[i - coin] + 1)
     *
     */
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int coin : coins) {
      for (int i = 1; i <= amount; i++) {
        if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
    }
    return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
  }

  public static void main(String[] args) {
    LC322 l = new LC322();
    l.coinChange(new int[]{1, 2, 5}, 11);
  }
}