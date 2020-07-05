package ds.queue.test;

import ds.queue.QueueAndBFS;

public class TestQueueAndBFS {
    private static final QueueAndBFS queueAndBFS = new QueueAndBFS();

    public static void testNumIslands() {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        QueueAndBFS queueAndBFS = new QueueAndBFS();
        System.out.println(queueAndBFS.numIslands(grid1));
        System.out.println(queueAndBFS.numIslands(grid2));
    }

    public static void main(String[] args) {
        testNumIslands();
    }
}
