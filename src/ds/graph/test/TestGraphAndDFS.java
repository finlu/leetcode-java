package ds.graph.test;

import ds.graph.GraphAndDFS;

public class TestGraphAndDFS {
    private static final GraphAndDFS graphAndDFS;

    static {
        graphAndDFS = new GraphAndDFS();
    }

    public static void testUniquePathsWithObstacles() {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("起点到终点的不同路径为：" + graphAndDFS.uniquePathsWithObstacles(obstacleGrid));
    }

    public static void main(String[] args) {
        testUniquePathsWithObstacles();
    }
}
