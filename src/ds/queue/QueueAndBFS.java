package ds.queue;

import java.util.*;

/**
 * 使用队列来实现BFS的一些简单例题
 */
public class QueueAndBFS {

    /**
     * 岛屿数量
     * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/872/
     * 核心思想：从第一个 '1' 开始触发bfs进行广度优先遍历，当bfs遍历到该位置的时候，将该位置加入到bfs的队列中，同时将该值变为 '0'；
     * 在遍历过程中，使用 res 变量来记录下岛屿的个数。
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nRows = grid.length;
        int nCols = grid[0].length;
        int res = 0;

        class Node {
            public final int i;
            public final int j;

            Node(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                // 触发dfs的条件
                if (grid[i][j] == '1') {
                    res++;
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        int n = node.i, c = node.j;
                        if (n > 0 && grid[n - 1][c] == '1') {
                            queue.offer(new Node(n - 1, c));
                            grid[n - 1][c] = '0';
                        }
                        if (n < nRows - 1 && grid[n + 1][c] == '1') {
                            queue.offer(new Node(n + 1, c));
                            grid[n + 1][c] = '0';
                        }
                        if (c > 0 && grid[n][c - 1] == '1') {
                            queue.offer(new Node(n, c - 1));
                            grid[n][c - 1] = '0';
                        }
                        if (c < nCols - 1 && grid[n][c + 1] == '1') {
                            queue.offer(new Node(n, c + 1));
                            grid[n][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 打开转盘锁
     * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/873/
     * 核心思想：在每个数值的四个位置上都有两个操作：加和减，所以使用BFS遍历所有可能的结果；
     * 同时为了避免回头，需要使用一个visited的集合来记录下已经遍历过的数值。
     * 如果BFS过程中形成的数值等于目标数值，则找到了最小的旋转次数；否则就是无论如何都不能解锁，返回-1。
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        class Helper {
            String plus(String s, int j) {
                if (s == null || j > s.length() - 1) {
                    return "";
                }
                char[] ch = s.toCharArray();
                if (ch[j] == '9') {
                    ch[j] = '0';
                } else {
                    ch[j] += 1;
                }
                return new String(ch);
            }

            String minus(String s, int j) {
                if (s == null || j > s.length() - 1) {
                    return "";
                }
                char[] ch = s.toCharArray();
                if (ch[j] == '0') {
                    ch[j] = '9';
                } else {
                    ch[j] -= 1;
                }
                return new String(ch);
            }
        }
        Helper helper = new Helper();
        Set<String> s = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int res = 0; // 返回结果
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        q.offer(start);
        // 如果目标值就是死亡数字中的值，直接返回不存在！
        if (visited.contains(start)) {
            return -1;
        }

        while (!q.isEmpty()) {
            int qs = q.size();
            // 从队列中扩散
            for (int k = 0; k < qs; k++) {
                String tmp = q.poll();

                // 判断是否达到终点
                if (target.equals(tmp)) {
                    return res;
                }

                // 找到附近的节点
                for (int i = 0; i < 4; i++) {
                    String up = helper.plus(tmp, i);
                    String down = helper.minus(tmp, i);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    /**
     * 完全平方数
     * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
     * <p>
     * 核心思想：首先求出满足范围的所有完全平方数；接下来完全平方数从大到小进行测试，使用一个队列来记录下当前所有的可以分解的数。
     * 如果当前待比较的完全平方数小于队列中的的值，则不做处理；如果相等，则说明此时已经找到结果了；如果大于队列中的值，则将当前队列中的数与完全平方数做差后在放入队列中。
     * <p>
     * 注意：由于这里对重复的数字进行分解没有意义，所以使用了集合来代替队列，集合中记录了每次出入队的元素。
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return -1;
        }
        int res = 0;
        int size = (int) Math.sqrt(n) + 1;
        // 1. 构造完全平方数集合
        int[] squareNums = new int[n];
        for (int i = 0; i < size; i++) {
            squareNums[i] = i * i;
        }

        // 2. 构造bfs遍历时需要的队列
        Set<Integer> queue = new HashSet<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            res++;
            Set<Integer> nextQueue = new HashSet<>();
            for (Integer item : queue) {
                // 遍历完全平方数
                for (int i = 0; i < size; i++) {
                    if (item < squareNums[i]) {
                        break;
                    } else if (item > squareNums[i]) {
                        nextQueue.add(item - squareNums[i]);
                    } else {
                        return res;
                    }
                }
            }
            queue = nextQueue;
        }
        return res;
    }

    /**
     * 钥匙和房间
     * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/893/
     * 核心思想：使用bfs从第一个房间触发往下遍历，再使用一个集合存储已经进入过的房间，集合的长度等于房间的数量则说明可以全部进入，返回true，否则返回false。
     *
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();  // BFS维护的钥匙的队列
        Set<Integer> s = new HashSet<>();  // 当前已经进入的房间
        s.add(0);
        for (int room : rooms.get(0)) {
            // 未进入过的房间则允许入队列
            if (!s.contains(room)) {
                q.offer(room);
                s.add(room);
            }
        }

        while (!q.isEmpty()) {
            int tmp = q.poll();
            List<Integer> l = rooms.get(tmp);
            for (Integer integer : l) {
                if (!s.contains(integer)) {
                    q.offer(integer);
                    s.add(integer);
                }
            }
        }
        return s.size() == rooms.size();
    }
}
