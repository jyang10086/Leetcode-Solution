class LC273 {
  /**
   *  
   *
   * Example 1:
   *
   * Input: num = 123
   * Output: "One Hundred Twenty Three"
   * Example 2:
   *
   * Input: num = 12345
   * Output: "Twelve Thousand Three Hundred Forty Five"
   * Example 3:
   *
   * Input: num = 1234567
   * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
   * Example 4:
   *
   * Input: num = 1234567891
   * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
   * */
  String[] nineteen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  String[] thousands = {"", "Thousand", "Million", "Billion", "Thrillion"};
  // O(1)
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    String word = "";
    int i = 0; // million
    while(num > 0) {
      int r = num % 1000;
      if (r != 0 ){
        word = getLessThanThousand(r) + " " + thousands[i] + " " +  word;
      }
      i++;
      num /= 1000;
    }
    return word.trim();
  }
  private String getLessThanThousand(int num) {
    if (num == 0) {
      return "";
    }
    if (num <= 19) {
      return nineteen[num];
    }
    // 20 - 99
    if (num <= 99) {
      return num % 10 == 0 ? tens[num / 10] : tens[num / 10] + " " + nineteen[num % 10];
    }
    // 100 - 999
    return num % 100 == 0 ? nineteen[num / 100] + " Hundred" :
        nineteen[num / 100] + " Hundred " + getLessThanThousand(num % 100);
  }
}