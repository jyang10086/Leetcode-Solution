public class WordFilter {
    Trie root = new Trie();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            //int ch = word.charAt(i) - 'a';
            //TrieNode node = new TrieNode();
            int len = words[i].length();
            String word = words[i];
            for (int j = 0; j < len; j++) {
                root.insert(word.substring(j, len) + "{" + word, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return root.startWith(suffix + "{" + prefix);
    }


    public static void main(String[] args) {
        String[] strs = {"apple", "appple"};
        WordFilter wf = new WordFilter(strs);
        System.out.println(wf.f("a", "e"));

    }
}
