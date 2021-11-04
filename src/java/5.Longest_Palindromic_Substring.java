class LC5 {
  public String longestPalindrome(String s) {
    // dp(i, i)  = true
    // dp(i, j)  = dp(i - 1, j - 1),  if s[i] == s[j]
    // dp(i, i + 1) = true if s[i] == s[j]
    // O(n^2) 17 min
    int N = s.length();
    String ans = "";
    boolean[][] dp = new boolean[N][N];
    // j -> col , i -> row
    for (int j = 0; j < N; j++) {
      for (int i = 0; i < N; i ++) {
        if (i > j) continue;
        if (i == j) {
          dp[i][j] = true;
        } else if (i + 1 == j && s.charAt(i) == s.charAt(i + 1)) {
          dp[i][j] = true;
        } else if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] =  dp[i + 1][j - 1];
        }
        if (dp[i][j] && j - i + 1 > ans.length()) {
          ans = s.substring(i, j + 1);
        }
      }
    }
    return ans;
  }
}