package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/implement-trie-prefix-tree/description/">Implement Trie (Prefix Tree)</a>
 */
public class Trie {

    public final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.child.putIfAbsent(ch, new TrieNode());
            curr = curr.child.get(ch);
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public void startsWith(TrieNode node, StringBuilder sb, List<String> result) {
        System.out.println("Start with:" + sb.toString());
        if (result.size() == 3) {
            return;
        }
        if (node.isWordEnd) {
            System.out.println("Adding word:" + sb.toString() + " to array size:" + result.size());
            result.add(sb.toString());
        }
        if (node.child.isEmpty()) {
            return;
        }
        for (int i = 97; i <= 122; i++) {
            char ch = (char) i;
            if (node.child.containsKey(ch)) {
                System.out.println("Contains char:" + ch);
                startsWith(node.child.get(ch), new StringBuilder(sb.toString().concat("" + ch)), result);
            }
        }

    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            if (!curr.child.containsKey(ch)) {
                return null;
            }
            curr = curr.child.get(ch);
        }
        return curr;
    }

}

class TrieNode {

    Map<Character, TrieNode> child;

    boolean isWordEnd;

    TrieNode() {
        child = new HashMap<>();
        isWordEnd = false;
    }

}
