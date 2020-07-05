package ds.stack;

public class StackAndDFS {

    /**
     * 目标和
     * https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/885/
     * 核心思想：递归调用dfs，dfs传递的信息为nums数组，当前使用的元素的位置，剩余的目标和
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
}
