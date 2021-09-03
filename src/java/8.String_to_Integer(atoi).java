class LC8 {
  /**
   * Example 1:
   * <p>
   * Input: s = "42"
   * Output: 42
   * <p>
   * <p>
   * Example 2:
   * <p>
   * Input: s = "   -42"
   * Output: -42
   * Explanation:
   * <p>
   * <p>
   * Example 3:
   * <p>
   * Input: s = "4193 with words"
   * Output: 4193
   * Explanation:
   * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
   * ^
   * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
   * ^
   * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
   * ^
   * The parsed integer is 4193.
   * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
   * Example 4:
   * <p>
   * Input: s = "words and 987"
   * Output: 0
   * Explanation:
   * Step 1: "words and 987" (no characters read because there is no leading whitespace)
   * ^
   * Step 2: "words and 987" (no characters read because there is neither a '-' nor '+')
   * ^
   * Step 3: "words and 987" (reading stops immediately because there is a non-digit 'w')
   * ^
   * The parsed integer is 0 because no digits were read.
   * Since 0 is in the range [-231, 231 - 1], the final result is 0.
   * Example 5:
   * <p>
   * Input: s = "-91283472332"
   * Output: -2147483648
   * Explanation:
   * Step 1: "-91283472332" (no characters read because there is no leading whitespace)
   * ^
   * Step 2: "-91283472332" ('-' is read, so the result should be negative)
   * ^
   * Step 3: "-91283472332" ("91283472332" is read in)
   * ^
   * The parsed integer is -91283472332.
   * Since -91283472332 is less than the lower bound of the range [-2^31, 2^31 - 1], the final result is clamped to -231 = -2147483648.
   */
  public int myAtoi(String s) {
    char[] str = s.toCharArray();
    int i = 0;
    while (i < str.length && str[i] == ' ') i++;
    boolean positive = true;
    if (i == str.length) return 0;
    if (str[i] == '+') {
      i++;
    } else if (str[i] == '-') {
      positive = false;
      i++;
    }
    int val = 0;
    while (i < str.length && str[i] >= '0' && str[i] <= '9') {
      int cur = str[i] - '0';
      // val * 10 + cur > Integer.MAX_VALUE
      if (val > (Integer.MAX_VALUE - cur) / 10) {
        return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      val = val * 10 + cur;
      i++;
    }
    return positive ? val : -val;
  }
}