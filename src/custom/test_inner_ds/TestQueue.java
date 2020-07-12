package custom.test_inner_ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试java中内置的队列接口及其实现类
 * <p>
 * java中定一个一个队列接口：Queue继承自Collection，可以使用LinkedList来作为其实现类
 */
public class TestQueue {
    public static void main(String[] args) {
        // 1. 创建一个队列
        Queue<Integer> queue = new LinkedList<>();

        // 2. 向队列中插入一个元素（入队列）
        queue.offer(1);
        queue.offer(5);
        queue.offer(3);
        // add也可以作为入队的API，为 Collection 接口的方法
        // 区别：offer在插入失败时返回false，add直接报错
        queue.add(2);

        // 3. 从队列中移除一个元素
        queue.poll();
        queue.poll();
        // remove也可以作为出队操作的API，为 Collection 接口的方法
        // 区别：poll在删除失败时返回false，remove直接报错
        queue.remove();
        queue.remove();

        // 4. 查看队列的大小
        System.out.println(queue.size());

        // 5. 判断队列是否为空
        System.out.println(queue.isEmpty());

        // 6. 返回队头元素
        System.out.println(queue.peek());
        // element方法也可以返回队头元素
        // 区别：peek方法在空队列上调用返回null，element方法直接报错：NoSuchElementException
        System.out.println(queue.element());
    }
}
