import java.util.ArrayDeque;
import java.util.Deque;

class LC227 {
  /***
   *
   * Example 1:
   *
   * Input: s = "3+2*2"
   * Output: 7
   * Example 2:
   *
   * Input: s = " 3/2 "
   * Output: 1
   * Example 3:
   *
   * Input: s = " 3+5 / 2 "
   * Output: 5
   *
   *
   */
  public int calculate(String s) {
    Deque<Integer> numStack = new ArrayDeque<>();
    int num = 0;
    char sign = '+';
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch >= '0' && ch <= '9') {
        num = num * 10 + (ch - '0');
      }
      // else if (ch == '(') {
      //   int j = i + 1, cnt = 1;
      //   while (j++ < s.length()) {
      //     if(s.charAt(j) == '(') cnt++;
      //     if(s.charAt(j) == ')') cnt--;
      //     if(cnt == 0) break;
      //   }
      //   num = calculate(s.substring(i + 1, j));
      //   i = j;
      // }
      if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
        switch (sign) {
          case '+':
            numStack.push(num);
            break;
          case '-':
            numStack.push(-num);
            break;
          case '*':
            numStack.push(numStack.pop() * num);
            break;
          case '/':
            numStack.push(numStack.pop() / num);
            break;
        }
        sign = ch;
        num = 0;
      }
    }
    int result = 0;
    while (!numStack.isEmpty()) {
      // System.out.println(numStack.peek());
      result += numStack.pop();
    }
    return result;
  }

  public static void main(String[] args) {
    LC227 l = new LC227();
    int res = l.calculate("3+2*2");
    System.out.println(res);
  }

}