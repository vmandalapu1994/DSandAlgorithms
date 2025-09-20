package monotonicstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/online-stock-span/description/">Online Stock Span</a>
 */

class StockSpanner1 {

    private final Stack<int[]> stack;

    public StockSpanner1() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the popped elements spans
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}


class StockSpanner2 {

    private Stack<Integer> stack;
    private List<Integer> elements;

    public StockSpanner2() {
        stack = new Stack();
        elements = new ArrayList<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && elements.get(stack.peek()) <= price) {
            stack.pop();
        }
        int result = stack.isEmpty() ? (1 + elements.size()) : elements.size() - stack.peek();
        elements.add(price);
        stack.push(elements.size() - 1);
        return result;
    }
}