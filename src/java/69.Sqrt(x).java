class LC69 {
  public int mySqrt(int x) {
    if (x <= 1) return x;
    int l = 1, r = x;
    //.    m
    //  1, 2, 3
    //  <  <  >
    int res = 0;
    while(l <= r) {
      int mid = l + (r - l) / 2;
      if (x / mid == mid) {
        return mid;
      } else if (x / mid < mid) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return r;
  }
}