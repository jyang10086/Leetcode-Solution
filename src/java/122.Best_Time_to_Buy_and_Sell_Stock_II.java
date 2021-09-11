class LC122 {
  /**
   *  You can only hold at most one share of the stock at any time.
   *  However, you can buy it then immediately sell it on the same day.
   *
   *
   */
  public int maxProfit(int[] prices) {
    // O(n)
    int maxProfit = 0;
    for (int i = 0; i + 1 < prices.length; i++) {
      // 当天卖出后还可以买
      maxProfit += Math.max(prices[i + 1] - prices[i], 0);
    }
    return maxProfit;
  }
}