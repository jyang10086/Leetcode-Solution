class LC516 {
  public int longestPalindromeSubseq(String s) {
    /***
     time: O(n^2)
     dp[i][j] : cnt
     if s[i] == s[j]:  dp[i + 1][j - 1] + 2
     else : max(dp[i + 1][j], dp[i][j - 1])
     */
    int len = s.length();
    int[][] dp = new int[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = 1;
    }
    char[] chars = s.toCharArray();
    for (int i = len - 1; i >= 0; i--) { // i 依赖 i + 1 则 i from N to 0
      for (int j = i + 1; j < len; j++) {
        if (chars[i] == chars[j]) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][len - 1];
  }
}