import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * <p>
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
class LC394 {
  public String decodeString(String s) {
    /***
     two stack: digit, letter
     s[i] == '[' :
     digit.push(val); letter.push(val)
     s[i] is str :
     str += s[i]
     s[i] == ']' :
     pop letter, pop digit
     */
    Deque<Integer> digits = new ArrayDeque<>();
    Deque<String> letters = new ArrayDeque<>();
    int i = 0;
    int digit = 0;
    String cur = "";
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        digit = digit * 10 + ch - '0';
      } else if (Character.isLetter(ch)) {
        cur += ch;
      } else if (ch == '[') {
        digits.push(digit);
        letters.push(cur);
        cur = "";
        digit = 0;
      } else if (ch == ']') {
        int cnt = digits.pop();
        String tmp = letters.pop();
        while (cnt-- > 0) {
          tmp += cur;
        }
        cur = tmp;
      }
      i++;
    }
    return cur;
  }

  /****
   * 递归
   */
  public String decodeString2(String s) {
    int idx = 0;
    StringBuilder cur = new StringBuilder();
    while (idx < s.length()) {
      char ch = s.charAt(idx);
      if (Character.isLetter(ch)) {
        cur.append(ch);
        idx++;
      } else if (Character.isDigit(ch)) {
        int k = idx;
        while (k < s.length() && Character.isDigit(s.charAt(k))) {
          k++;
        }
        int digit = Integer.parseInt(s.substring(idx, k));
        idx = k;

        if (s.charAt(idx) == '[') {
          int leftCnt = 1;
          int r = idx + 1;
          while (r < s.length()) {
            if (s.charAt(r) == '[') {
              leftCnt++;
            } else if (s.charAt(r) == ']') {
              leftCnt--;
            }
            if (leftCnt == 0) {
              break;
            }
            r++;
          }
          String str = decodeString(s.substring(idx + 1, r));
          String tmp = getRepeatedStr(str, digit);
          cur.append(tmp);
//          while (digit-- > 0) {
//            cur.append(str);
//          }
          idx = r + 1;
        }
      }
    }
    return cur.toString();
  }

  private String getRepeatedStr(String str, int cnt) {
    if (cnt == 0) {
      return "";
    }
    if (cnt == 1) {
      return str;
    }
    if (cnt % 2 == 1) {
      return str + getRepeatedStr(str, cnt - 1);
    }
    String s = getRepeatedStr(str, cnt / 2);
    return s + s;
  }
}