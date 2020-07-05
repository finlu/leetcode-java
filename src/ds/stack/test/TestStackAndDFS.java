package ds.stack.test;

import ds.stack.StackAndDFS;

public class TestStackAndDFS {
    private static final StackAndDFS stackAndDFS = new StackAndDFS();

    public static void testFindTargetSumWays() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        assert stackAndDFS.findTargetSumWays(nums, target) == 5;
        System.out.println("Your code is AC!!!");
    }

    public static void main(String[] args) {
        testFindTargetSumWays();
    }
}
