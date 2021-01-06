package lcp.p5;

interface LongestPalindromeInterface {
    String longestPalindrome(String s);
}

/**
 * 暴力解法
 */
class Solution1 implements LongestPalindromeInterface {
    /**
     * 判断left到right间的字符构造成的串是不是一个回文串
     * 
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Override
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int begin = 0, maxLen = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > maxLen && this.validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

/**
 * 动态规划
 */
class Solution2 implements LongestPalindromeInterface {
    @Override
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int begin = 0, maxLen = 0;
        // l 表示可能的回文串的长度-1
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > maxLen) {
                    begin = i;
                    maxLen = l + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

/**
 * 中心扩展算法
 */
class Solution3 implements LongestPalindromeInterface {
    @Override
    public String longestPalindrome(String s) {
        // TODO Auto-generated method stub
        return null;
    }
}

/**
 * Manacher 算法
 */
class Solution4 implements LongestPalindromeInterface {
    @Override
    public String longestPalindrome(String s) {
        // TODO Auto-generated method stub
        return null;
    }
}

/**
 * 最长回文子串:
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 */
public class Solution {
    private static void testLongestPalindrome(LongestPalindromeInterface longestPalindromeInterface) {
        long startTime = System.currentTimeMillis();
        System.out.println("最长回文子串");
        String[] inputs = new String[] { "babad" };
        for (String input : inputs) {
            System.out.println(input + " ==> " + longestPalindromeInterface.longestPalindrome(input));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("cost: " + (endTime - startTime) + "s");
    }

    public static void main(String[] args) {
        LongestPalindromeInterface longestPalindromeInterface1 = new Solution1();
        LongestPalindromeInterface longestPalindromeInterface2 = new Solution2();
        testLongestPalindrome(longestPalindromeInterface1);
        testLongestPalindrome(longestPalindromeInterface2);
    }
}
