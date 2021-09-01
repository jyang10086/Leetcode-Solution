import java.util.ArrayDeque;
import java.util.Deque;

class LC224 {
  /***
   * Example 1:
   *
   * Input: s = "1 + 1"
   * Output: 2
   * Example 2:
   *
   * Input: s = " 2 - 1 + 2 "
   * Output: 3
   * Example 3:
   *
   * Input: s = "(1+(4+5+2)-3)+(6+8)"
   * Output: 23
   *
   */
  public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int val = 0;
    int sign = 1; // positive
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        int tmp = ch - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          tmp = tmp * 10 + (s.charAt(i + 1) - '0');
        }
        val += sign * tmp;
      } else if (ch == '+') {
        sign = 1;
      } else if (ch == '-') {
        sign = -1;
      } else if (ch == '(') {
        stack.push(val);
        stack.push(sign);
        val = 0;
        sign = 1;
      } else if (ch == ')') {
        val = stack.pop() * val + stack.pop();
      }
    }
    return val;
  }

  public static void main(String[] args) {
    LC224 s = new LC224();
    int res = s.calculate("(1+(4+5+2)-3)+(6+8)");
    System.out.println(res);
  }
}