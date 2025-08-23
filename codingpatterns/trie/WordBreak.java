package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/word-break/description/">Word Break</a>
 */
public class WordBreak {

    Trie t = new Trie();

    // Add memoization to not compute repeated subproblems
    Map<String, Boolean> mem = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        mem.put("", true);

        for (String word : wordDict) {
            t.insert(word);
        }

        return canBreak(t.root, s);
    }

    boolean canBreak(TrieNode root, String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!curr.child.containsKey(ch)) {
                mem.put(s, false);
                return false;
            }
            curr = curr.child.get(ch);
            if (curr.isWord) {
                // Check break condition here and proceed to next iteration only when the string can't be split successfully.
                if (canBreak(t.root, s.substring(i + 1))) {
                    mem.put(s, true);
                    return true;
                }
            }
        }
        mem.put(s, false);
        return false;
    }

}
