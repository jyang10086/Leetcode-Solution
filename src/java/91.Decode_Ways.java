class LC91 {
  /*

  A message containing letters from A-Z can be encoded into numbers using the following mapping:
  'A' -> "1"
  'B' -> "2"
  ...
  'Z' -> "26"
  Given a string s containing only digits, return the number of ways to decode it.


  Example 1:
  Input: s = "12"
  Output: 2
  Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
  Example 2:

  Input: s = "226"
  Output: 3
  Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

  *
  **/
  public int numDecodings(String s) {
    /**
     *
     * dp[i]:
     * s[i] ->[1, 9]  = dp[i - 1]
     * s[i - 1, i] -> [10, 26]  +=dp[i - 2]
     *
     * **/
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    for (int i = 1; i <= s.length(); i++) {
      int cur = s.charAt(i - 1) - '0';
      if (cur != 0) {
        dp[i] = dp[i - 1];
      }
      if (i > 1) {
        int pre = s.charAt(i - 2) - '0';
        if (pre == 1 || (pre == 2 && cur <= 6)) {
          dp[i] += dp[i - 2];
        }
      }
    }
    return dp[s.length()];
  }
}