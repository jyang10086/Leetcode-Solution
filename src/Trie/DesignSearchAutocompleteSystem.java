package Trie;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class AutocompleteSystem {
    class TrieNode {
        TrieNode[] children;
        List<TrieNode> hotnessHeap;
        int times;
        String sentence;

        public TrieNode() {
            children = new TrieNode[27];
            times = 0;
            hotnessHeap = new LinkedList<>();
        }

        public void update(TrieNode node) {
            if (!this.hotnessHeap.contains(node)) {
                this.hotnessHeap.add(node);
            }
            Comparator<TrieNode> comparator = new Comparator<TrieNode>() {
                @Override
                public int compare(TrieNode node1, TrieNode node2) {
                    if (node1.times != node2.times) {
                        return node2.times - node1.times;
                    }
                    return node1.sentence.compareTo(node2.sentence);
                }
            };
            Collections.sort(hotnessHeap, comparator);
            if (hotnessHeap.size() > 3) {
                hotnessHeap.remove(hotnessHeap.size() - 1);
            }
        }
    }

    TrieNode curNode;
    TrieNode root;
    StringBuilder curInput;

    public void buildTrie(String sentence, int times) {
        TrieNode tmp = root;
        List<TrieNode> visited = new LinkedList<>();
        for (char ch : sentence.toCharArray()) {
            int index = getIndex(ch);
            if (tmp.children[index] == null) {
                tmp.children[index] = new TrieNode();
            }
            tmp = tmp.children[index];
            visited.add(tmp);
        }
        tmp.sentence = sentence;
        tmp.times += times;
        for (TrieNode node : visited) {
            node.update(tmp);
        }
    }

    private int getIndex(char ch) {
        return ch == ' ' ? 26 : ch - 'a';
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        int n = sentences.length;
        root = new TrieNode();
        curNode = root;
        curInput = new StringBuilder();
        for (int i = 0; i < n; i++) {
            buildTrie(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> result = new LinkedList<>();
        if (c == '#') {
            buildTrie(curInput.toString(), 1);
            curInput = new StringBuilder();
            curNode = root;
            return result;
        }
        curInput.append(c);
        if (curNode != null) {
            int idx = getIndex(c);
            curNode = curNode.children[idx];
        }

        if (curNode == null) {
            return result;
        }
        for (TrieNode node : curNode.hotnessHeap) {
            result.add(node.sentence);
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
