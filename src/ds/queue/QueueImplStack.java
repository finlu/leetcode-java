package ds.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class QueueImplStack {
    private Queue<Integer> queue1;  // 输入队列
    private Queue<Integer> queue2;  // 输出队列（已经为栈格式的数据）

    /**
     * Initialize your data structure here.
     */
    public QueueImplStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // 1   push(1)
        // 2 1   push(2)  先入2，之后再把之前的1挪过来
        // 3 2 1  push(3)  先入3，之后再把21挪过来
        queue1.add(x);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue2.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue2.element();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue2.isEmpty();
    }

    public static void main(String[] args) {
        QueueImplStack queueImplStack = new QueueImplStack();
        queueImplStack.push(1);
        queueImplStack.push(2);
        System.out.println("当前栈顶元素为：" + queueImplStack.top());
        System.out.println("栈顶元素出栈：" + queueImplStack.pop());
        System.out.println("当前栈是否为空：" + queueImplStack.empty());

        QueueImplStack queueImplStack2 = new QueueImplStack();
        queueImplStack2.push(1);
        queueImplStack2.push(2);
        System.out.println("当前栈顶元素为：" + queueImplStack2.top());
        queueImplStack2.push(3);
        System.out.println("当前栈顶元素为：" + queueImplStack2.top());
        ;
    }
}
