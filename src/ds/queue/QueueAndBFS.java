package ds.queue;

import java.util.LinkedList;
import java.util.Queue;

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
}
