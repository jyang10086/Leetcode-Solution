class LC50 {
  public double myPow(double x, int n) {
    // O(logn)
    double res = 1.0;
    long s = Math.abs((long)n);
    while (s != 0){
      long bit = s & 1;
      if (bit == 1) {
        res *= x;
      }
      s >>= 1;
      x *= x;
    }
    return n < 0 ? 1 / res : res;
  }
}