import java.util.*;

/***
 *
 *A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,where word1 is a predecessor of word2,
 * word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 *
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 *
 *
 * **/
class LC1048 {
  public int longestStrChain(String[] words) {
    /**
     sort by length;
     dp[i] : max length of chain
     dp[i] = max(dp[predecessor]) + 1
     time：O(nlogn + n * (w + w))
     */
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    Map<String, Integer> map = new HashMap<>();
    int max = 1;
    for (String word : words) {
      List<String> predecessors = getPredecessors(word);
      int chainLen = 0;
      for (String pre : predecessors) {
        if (map.containsKey(pre)) {
          chainLen = Math.max(map.get(pre), chainLen);
        }
      }
      map.put(word, chainLen + 1);
      max = Math.max(max, chainLen + 1);
    }
    return max;
  }

  private List<String> getPredecessors(String word) {
    if (word.length() == 0) return null;
    List<String> predecessors = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      StringBuilder sb = new StringBuilder(word);
      predecessors.add(sb.deleteCharAt(i).toString());
    }
    return predecessors;
  }
}