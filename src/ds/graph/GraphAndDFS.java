package ds.graph;

import java.util.Arrays;

public class GraphAndDFS {

    /**
     * 不同路径II
     * https://leetcode-cn.com/problems/unique-paths-ii/
     * 核心思路：DFS遍历整个图，使用mem记录下子问题的解
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        class Helper {
            private final int[][] mem;

            Helper() {
                // 记录每个点到终点的路径条数，防止重复计算
                mem = new int[obstacleGrid.length][obstacleGrid[0].length];
                for (int[] ints : mem) {
                    Arrays.fill(ints, -1);
                }
            }

            int dfs(int[][] obstacleGrid, int r, int c) {
                int nr = obstacleGrid.length;
                int nc = obstacleGrid[0].length;

                // 递归终止条件
                if (r == nr - 1 && c == nc - 1) {
                    if (obstacleGrid[r][c] == 1) {
                        return 0;
                    } else {
                        return 1;
                    }
                }

                // 子问题已经计算过，直接返回
                if (mem[r][c] != -1) {
                    return mem[r][c];
                }

                // 求出当前节点到终点的路径条数
                int total = 0;
                // 往下走，注意越界
                if (r < nr - 1 && obstacleGrid[r + 1][c] == 0) {
                    total += dfs(obstacleGrid, r + 1, c);
                }
                // 往右走，注意越界
                if (c < nc - 1 && obstacleGrid[r][c + 1] == 0) {
                    total += dfs(obstacleGrid, r, c + 1);
                }

                mem[r][c] = total;

                return total;
            }
        }

        return new Helper().dfs(obstacleGrid, 0, 0);
    }

}
