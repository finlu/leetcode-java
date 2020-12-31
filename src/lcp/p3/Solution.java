package lcp.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface LengthOfLongestSubstringInterface {
    int lengthOfLongestSubstring(String s);
}

/**
 * 动态规划
 */
class Solution1 implements LengthOfLongestSubstringInterface {

    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            int j = i - 1;
            for (; j >= i - dp[i - 1]; j--) {
                if (s.charAt(j - 1) == s.charAt(i - 1)) {
                    break;
                }
            }
            dp[i] = i - j;
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}

/**
 * 滑动窗口
 */
class Solution2 implements LengthOfLongestSubstringInterface {

    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int rk = -1, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 当右指针扫描的
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

/**
 * 无重复字符的最长子串:
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    private static void testLengthOfLongestSubstring(
            LengthOfLongestSubstringInterface lengthOfLongestSubstringInterface) {
        long startTime = System.currentTimeMillis();
        List<String> sList = new ArrayList<>(List.of("abcabcbb", "bbbbb", "pwwkew", ""));
        List<Integer> rList = new ArrayList<>(List.of(3, 1, 3, 0));
        for (int i = 0; i < sList.size(); i++) {
            String s = sList.get(i);
            int r = rList.get(i);
            int pr = lengthOfLongestSubstringInterface.lengthOfLongestSubstring(s);
            System.out.println(s + " --> " + pr + (r == pr));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("cost: " + (endTime - startTime) + "s");
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringInterface lengthOfLongestSubstringInterface1 = new Solution1();
        LengthOfLongestSubstringInterface lengthOfLongestSubstringInterface2 = new Solution2();
        testLengthOfLongestSubstring(lengthOfLongestSubstringInterface1);
        testLengthOfLongestSubstring(lengthOfLongestSubstringInterface2);
    }
}
