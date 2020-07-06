package ds.stack;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class StackImplQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public StackImplQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        StackImplQueue stackImplQueue = new StackImplQueue();
        stackImplQueue.push(1);
        stackImplQueue.push(2);
        System.out.println("队头元素为：" + stackImplQueue.peek());
        System.out.println("删除队头元素：" + stackImplQueue.pop());
        System.out.println("当前队列是否为空：" + stackImplQueue.empty());
    }
}
