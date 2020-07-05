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
        System.out.println(queueAndBFS.numIslands(grid1));
        System.out.println(queueAndBFS.numIslands(grid2));
    }

    public static void testOpenLock() {
        String[] deadends1 = {"0201", "0101", "0102", "1212", "2002"};
        String target1 = "0202";
        String[] deadends2 = {"8888"};
        String target2 = "0009";
        String[] deadends3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target3 = "8888";
        System.out.println(queueAndBFS.openLock(deadends1, target1));
        System.out.println(queueAndBFS.openLock(deadends2, target2));
        System.out.println(queueAndBFS.openLock(deadends3, target3));
    }

    public static void testNumSquares() {
        assert queueAndBFS.numSquares(12) == 3;
        assert queueAndBFS.numSquares(13) == 2;
        System.out.println("Your code is AC!!!");
    }

    public static void main(String[] args) {
//        testNumIslands();
//        testOpenLock();
        testNumSquares();
    }
}
