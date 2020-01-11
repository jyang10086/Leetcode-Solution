public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str, int weight) {
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';
            if (cur.children[ch] == null) {
                cur.children[ch] = new TrieNode();
            }
            cur = cur.children[ch];
            cur.weight = weight;
        }
    }

    public int startWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            System.out.println(ch);
            TrieNode next = cur.children[ch];
            if (next == null) return -1;
            cur = next;
        }
        return cur.weight;
    }

}
