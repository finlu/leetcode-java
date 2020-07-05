package ds.stack;

import java.util.*;

public class StackAndDFS {

    /**
     * 目标和
     * https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/885/
     * 核心思想：递归调用dfs，dfs传递的信息为nums数组，当前使用的元素的位置，剩余的目标和
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        class Helper {
            int res;

            void dfs(int[] nums, int cur, int target) {
                if (cur == nums.length) {
                    if (target == 0) {
                        res++;
                    }
                    return;
                }
                dfs(nums, cur + 1, target - nums[cur]);
                dfs(nums, cur + 1, target + nums[cur]);
            }

            int findTargetSumWays(int[] nums, int S) {
                dfs(nums, 0, S);
                return res;
            }
        }
        return new Helper().findTargetSumWays(nums, S);
    }

    /**
     * 克隆图
     * https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/884/
     * 核心思想：使用方法：DFS遍历图。递归结束条件：节点为null或者节点已经被处理过。
     * 递归函数中需要对每个节点的处理：1. 克隆当前节点；2. 将当前节点加入到已访问集合中； 3. 递归克隆其邻居节点对应的子图。
     * 递归函数的返回：返回已经克隆好的图。
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        class Helper {
            // 记录当前节点与克隆后节点之间的映射关系
            final Map<Node, Node> visited = new HashMap<>();

            /**
             * 递归函数返回当前节点及其子图的克隆
             * @param innerNode
             * @return
             */
            Node cloneGraph(Node innerNode) {
                if (node == null) {
                    return null;
                }
                // 已经构造过，直接返回克隆好的节点
                if (visited.containsKey(innerNode)) {
                    return visited.get(innerNode);
                }

                // 创建当前节点的克隆
                Node cloneNode = new Node(innerNode.val, new ArrayList<>());
                visited.put(innerNode, cloneNode);

                // 处理其 neighbors
                for (Node neighbor : innerNode.neighbors) {
                    cloneNode.neighbors.add(cloneGraph(neighbor));
                }
                return cloneNode;
            }
        }

        return new Helper().cloneGraph(node);
    }
}
