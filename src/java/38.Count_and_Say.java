class LC38 {
  /*
  Example 1:

  Input: n = 1
  Output: "1"
  Explanation: This is the base case.

  Example 2:
  Input: n = 4
  Output: "1211"
  Explanation:
  countAndSay(1) = "1"
  countAndSay(2) = say "1" = one 1 = "11"
  countAndSay(3) = say "11" = two 1's = "21"
  countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
  **/
  public String countAndSay(int n) {
    if (n == 1) return "1";
    String pre = "1";
    for (int i = 0; i < n - 1; i++) {
      String cur = "";
      int j = 0;
      while (j < pre.length()) {
        int k = j + 1;
        while(k < pre.length() && pre.charAt(k) == pre.charAt(j)) k++;
        cur += String.valueOf(k - j);
        cur += pre.charAt(j);
        j = k;
      }
      pre = cur.toString();
    }
    return pre;
  }
}