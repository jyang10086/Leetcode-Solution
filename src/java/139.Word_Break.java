class LC139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    // O(n^2)
    Set<String> wordSet = new HashSet<>();
    for(String word : wordDict) {
      wordSet.add(word);
    }
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = i; j >= 0; j--) {
        if (wordSet.contains(s.substring(j, i)) && dp[j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }
}