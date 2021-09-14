class LC127 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>();
    for (String word : wordList) {
      dict.add(word);
    }
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    Set<String> visited = new HashSet<>();
    int length = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        String cur = q.poll();
        for (int i = 0; i < cur.length(); i++) {
          char[] newWord = cur.toCharArray();
          for (char ch = 'a'; ch <= 'z'; ch++) {
            newWord[i] = ch;
            String newStr = String.valueOf(newWord);
            if (dict.contains(newStr)) {
              if (newStr.equals(endWord)) {
                return length + 1;
              }
              if (!visited.contains(newStr)) {
                q.offer(newStr);
                visited.add(newStr);
              }
            }
          }
        }
      }
      length++;
    }
    return 0;
  }
}