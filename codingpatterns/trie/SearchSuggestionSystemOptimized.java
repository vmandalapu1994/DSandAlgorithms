package trie;

import java.util.*;


/**
 * @see <a href="https://leetcode.com/problems/search-suggestions-system/description/">Search Suggestions System</a>
 */
public class SearchSuggestionSystemOptimized {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        SearchOptimizedTrie t = new SearchOptimizedTrie();
        for (String p : products) {
            t.insert(p);
        }

        List<List<String>> result = new ArrayList<>();

        SearchOptimizedTrieNode curr = t.root;

        for (char ch : searchWord.toCharArray()) {
            if (curr.child.containsKey(ch)) {
                List<String> res = curr.child.get(ch).suggestions;
                result.add(res);
                curr = curr.child.get(ch);
            } else {
                while (result.size() < searchWord.length()) {
                    result.add(List.of());
                }
                break;
            }
        }
        return result;
    }
}

class SearchOptimizedTrie {

    public final SearchOptimizedTrieNode root;

    public SearchOptimizedTrie() {
        root = new SearchOptimizedTrieNode();
    }

    public void insert(String word) {
        SearchOptimizedTrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.child.putIfAbsent(ch, new SearchOptimizedTrieNode());
            curr = curr.child.get(ch);
            if (curr.suggestions.size() < 3) {
                curr.suggestions.add(word);
            }
        }
        curr.isWordEnd = true;
    }

}

class SearchOptimizedTrieNode {

    Map<Character, SearchOptimizedTrieNode> child;

    boolean isWordEnd;

    List<String> suggestions;

    SearchOptimizedTrieNode() {
        child = new HashMap<>();
        suggestions = new ArrayList<>();
        isWordEnd = false;
    }

}

