package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/search-suggestions-system/description/">Search Suggestions System</a>
 */
public class SearchSuggestionSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie t = new Trie();
        for (String p : products) {
            t.insert(p);
        }

        StringBuilder sb = new StringBuilder();

        List<List<String>> result = new ArrayList<>();

        for (char ch : searchWord.toCharArray()) {
            sb.append(ch);
            TrieNode tn = t.searchPrefix(sb.toString());
            if (tn == null) {
                while (result.size() < searchWord.length()) {
                    result.add(new ArrayList<>());
                }
                break;
            }
            List<String> res = new ArrayList<>();
            t.startsWith(tn, sb, res);
            result.add(res);
        }
        return result;
    }
}

class SearchTrie {

    private final SearchTrieNode root;

    public SearchTrie() {
        root = new SearchTrieNode();
    }

    public void insert(String word) {
        SearchTrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.child.putIfAbsent(ch, new SearchTrieNode());
            curr = curr.child.get(ch);
        }
        curr.isWordEnd = true;
    }

    public void startsWith(SearchTrieNode node, StringBuilder sb, List<String> result) {
        if (result.size() == 3) {
            return;
        }
        if (node.isWordEnd) {
            result.add(sb.toString());
        }
        if (node.child.isEmpty()) {
            return;
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.child.containsKey(ch)) {
                sb.append(ch);
                startsWith(node.child.get(ch), sb, result);
                sb.deleteCharAt(sb.length() - 1);
                if (result.size() == 3) {
                    return;
                }
            }
        }

    }

    public SearchTrieNode searchPrefix(String prefix) {
        SearchTrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            if (!curr.child.containsKey(ch)) {
                return null;
            }
            curr = curr.child.get(ch);
        }
        return curr;
    }

}

class SearchTrieNode {

    Map<Character, SearchTrieNode> child;

    boolean isWordEnd;

    SearchTrieNode() {
        child = new HashMap<>();
        isWordEnd = false;
    }

}

