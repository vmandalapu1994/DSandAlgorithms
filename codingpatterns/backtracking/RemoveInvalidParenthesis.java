package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/remove-invalid-parentheses/">Remove Invalid Parentheses</a>
 * <p>
 * Pseudo solution:
 * <p>
 * Scan the input string to count the minimum number of unmatched opening and closing parentheses that must be removed by checking each character and updating the removal counts based on balance.
 * <p>
 * Use a recursive approach to explore all possible ways to build a valid expression by choosing whether to keep or remove each character.
 * <p>
 * At each character, if it’s a parenthesis, try both removing it (if removals remain) and keeping it (if it keeps the expression valid).
 * <p>
 * If it’s a non-parenthesis character, always include it in the expression and continue the recursion.
 * <p>
 * When the end of the string is reached, check if the expression is valid and complete; if so, add it to the final result set and return all unique valid expressions.
 */

public class RemoveInvalidParenthesis {

    Set<String> validParenthesis = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftToRemove = 0, rightToRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftToRemove++;
            }
            if (s.charAt(i) == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }
        if (leftToRemove == 0 && rightToRemove == 0) {
            return List.of(s);
        }
        backTrack(s, 0, leftToRemove, rightToRemove, new StringBuilder(), 0, 0);
        return new ArrayList<>(validParenthesis);
    }

    public void backTrack(String s, int index, int leftToRemove, int rightToRemove, StringBuilder path, int openCount, int closedCount) {
        if (index == s.length()) {
            if (leftToRemove == 0 && rightToRemove == 0 && openCount == closedCount) {
                validParenthesis.add(path.toString());
            }
            return;
        }
        int len = path.length();
        if (s.charAt(index) == '(') {
            if (leftToRemove > 0) {
                // skip the open parenthesis
                backTrack(s, index + 1, leftToRemove - 1, rightToRemove, path, openCount, closedCount);
                path.setLength(len);
            }
            // include the open parenthesis
            path.append(s.charAt(index));
            backTrack(s, index + 1, leftToRemove, rightToRemove, path, openCount + 1, closedCount);
            path.setLength(len);
        } else if (s.charAt(index) == ')') {
            if (rightToRemove > 0) {
                // skip the closed parenthesis
                backTrack(s, index + 1, leftToRemove, rightToRemove - 1, path, openCount, closedCount);
                path.setLength(len);
            }
            if (openCount > closedCount) {
                // include the closed parenthesis
                path.append(s.charAt(index));
                backTrack(s, index + 1, leftToRemove, rightToRemove, path, openCount, closedCount + 1);
                path.setLength(len);
            }
        } else {
            path.append(s.charAt(index));
            backTrack(s, index + 1, leftToRemove, rightToRemove, path, openCount, closedCount);
            path.setLength(len);
        }
    }
}
