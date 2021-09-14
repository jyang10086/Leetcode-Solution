class LC204 {
  public int countPrimes(int n) {
    // time: O(n)
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    int cnt = 0;
    for (int i = 2; i < n; i++) {
      if (!isPrime[i]) continue;
      cnt++;
      for (int j = 2; i * j < n; j++) {
        isPrime[i * j] = false;
      }
    }
    return cnt;
  }
}