class Solution {
  /**
   *
   *
   * -2^31 <= dividend, divisor <= 2^31 - 1
   * divisor != 0
   *
   * Example 1:
   *
   * Input: dividend = 10, divisor = 3
   * Output: 3
   * Explanation: 10/3 = truncate(3.33333..) = 3.
   * Example 2:
   *
   * Input: dividend = 7, divisor = -3
   * Output: -2
   * Explanation: 7/-3 = truncate(-2.33333..) = -2.
   *
   * */
  public int divide(int dividend, int divisor) {
    /***
     10 = 3^2 + 3^0
     time: O(32)
     **/
    boolean positive = true;
    if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
      positive = false;
    }
    long x = Math.abs((long)dividend);
    long y = Math.abs((long)divisor);
    long result = 0;
    for (int i = 31; i >= 0; i--) {
      if ((y << i) <= x) {
        x -= y << i;
        result += (long) 1 << i;
      }
    }
    if (!positive) result = -result;
    if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
    return (int) result;
  }
}