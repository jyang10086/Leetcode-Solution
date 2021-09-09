class LC13 {
  public int romanToInt(String s) {
    HashMap<Character, Integer> romanMap = new HashMap();
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);
    int val = 0;
    char[] ch = s.toCharArray();
    for (int i = 0; i < ch.length; i++) {
      if (i + 1 < ch.length && romanMap.get(ch[i]) < romanMap.get(ch[i + 1]) ) {
        val -= romanMap.get(ch[i]);
      } else {
        val += romanMap.get(ch[i]);
      }
    }
    return val;
  }
}