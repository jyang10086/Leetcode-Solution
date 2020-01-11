public class TrieNode {
    TrieNode[] children;
    int weight;

    public TrieNode() {
        this.children = new TrieNode[27];
        this.weight = 0;
    }
}
