package ds.queue;

/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/865/
 * 自己设计实现一个循环队列
 */
public class CircularQueue {
    private int[] data;  // 内部维护的数组，存放实际的队列数据
    private int head;  // 队首指针
    private int tail;  // 队尾指针
    private int size;  // 队列大小

    /**
     * 初始化循环队列并设置循环队列的大小
     *
     * @param k
     */
    public CircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /**
     * 向队列中插入一个元素，如果插入成功则返回true；插入失败返回false
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /**
     * 从队列中删除一个元素，删除成功返回true；删除失败返回false
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /**
     * 获取队列的队头元素，如果队列为空则返回-1
     *
     * @return
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /**
     * 获取队列中的最后一个元素
     *
     * @return
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * 判断队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(2);
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isFull());
    }
}
