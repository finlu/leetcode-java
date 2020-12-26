package lcp.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface TwoSumInterface {
    int[] twoSum(int[] nums, int target);
}

class Solution1 implements TwoSumInterface {
    @Override
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; i < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}

class Solution2 implements TwoSumInterface {
    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                return new int[] { map.get(key), i };
            } else {
                map.put(target - key, i);
            }
        }
        return null;
    }
}

/**
 * 两数之和: https://leetcode-cn.com/problems/two-sum/
 */
public class Solution {

    private static void testTwoSum(TwoSumInterface twoSumInterface) {
        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSumInterface.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
        long endTime = System.currentTimeMillis();
        System.out.println("cost: " + (endTime - startTime) + "s");
    }

    public static void main(String[] args) {
        TwoSumInterface twoSumInterface1 = new Solution2();
        TwoSumInterface twoSumInterface2 = new Solution2();
        testTwoSum(twoSumInterface1);
        testTwoSum(twoSumInterface2);
    }
}
