package ds.queue;

import java.util.*;

/**
 * 使用队列来实现BFS的一些简单例题
 */
public class QueueAndBFS {

    /**
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
}
