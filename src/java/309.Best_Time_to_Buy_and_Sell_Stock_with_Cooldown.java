class LC309 {
  public int maxProfit(int[] prices) {
    /***
     dp[i][0] STOCK
     dp[i][1] NO STOCK
     dp[i][2] COOL
     */
    int[][] dp = new int[prices.length][3];
    dp[0][0] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      // already have stock or buy
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
      // cool or no stock
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
      // cool down
      dp[i][2] = dp[i - 1][0] + prices[i];
    }
    return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
  }
}