package trie;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/word-search-ii/">Word Search II</a>
 */
public class WordSearchII {

    private final int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        Set<String> wordsPresent = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                traverse(board, i, j, visited, trie.root, new StringBuilder(), wordsPresent);
            }
        }
        return new ArrayList<>(wordsPresent);
    }

    private void traverse(char[][] board, int row, int col, boolean[][] visited, TrieNode curr, StringBuilder word, Set<String> wordsPresent) {
        int rows = board.length;
        int cols = board[0].length;
        char ch = board[row][col];
        if(!curr.child.containsKey(ch)) {
            return;
        }
        visited[row][col] = true;
        curr = curr.child.get(ch);
        word.append(ch);
        if(curr.isWord) {
            wordsPresent.add(word.toString());
            curr.isWord =false;
        }
        for(int[] dir: directions) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && !visited[newRow][newCol]) {
                traverse(board, newRow, newCol, visited, curr, word, wordsPresent);
            }
        }
        word.setLength(word.length()-1);
        visited[row][col] = false;
    }
}
