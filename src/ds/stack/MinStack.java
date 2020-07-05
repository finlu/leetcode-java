package ds.stack;

import java.util.Stack;

/**
 * 最小栈
 * https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/877/
 * 核心思想：使用两个栈来处理数据，一个栈存储实际的数据，另一个栈存储当前栈中的最小值。
 * 入栈：直接进入数据栈，如果栈顶元素大于当前元素，则同时入最小值栈。
 * 出栈：直接出数据栈，如果出栈元素等于最小值栈的栈顶元素，则同时出最小值栈。
 */
class MinStack {
    private final Stack<Integer> dataStack;
    private final Stack<Integer> minStack;

    /**
     * 初始化数据栈和最小值栈
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 元素入最小值栈
     *
     * @param x
     */
    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    /**
     * 元素出最小值栈
     */
    public void pop() {
        int val = dataStack.pop();
        if (!minStack.isEmpty() && val == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * 获取最小值栈栈顶元素
     *
     * @return
     */
    public int top() {
        return dataStack.peek();
    }

    /**
     * 获取最小值栈中的最小值
     *
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(2);
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

