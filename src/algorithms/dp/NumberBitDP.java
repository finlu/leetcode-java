package algorithms.dp;

public class NumberBitDP {
    private final int[][] dp = new int[20][20];
    private final int[] digits = new int[20];

    private int dfs(int pos, int lim, int sum) {
        if (pos == 0) {
            return sum;
        }

        if (lim == 0 && dp[pos][sum] != 0) {
            return dp[pos][sum];
        }

        int up = lim == 1 ? digits[pos] : 9;
        int cnt = 0;
        for (int i = 0; i <= up; i++) {
            cnt += dfs(pos - 1, (lim == 1 && i == up) ? 1 : 0, sum + (i == 2 ? 1 : 0));
        }
        if (lim != 1) {
            dp[pos][sum] = cnt;
        }
        return cnt;
    }

    private int cal(int n) {
        int k = 0;
        while (n != 0) {
            digits[++k] = n % 10;
            n /= 10;
        }
        return dfs(k, 1, 0);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 2) {
            return 0;
        }
        return cal(n);
    }

    private void print() {
        for (int[] item : dp) {
            for (int i = 0; i < 20; i++) {
                System.out.print(item[i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NumberBitDP numberBitDP = new NumberBitDP();
        System.out.println(numberBitDP.NumberOf1Between1AndN_Solution(484742755));
        numberBitDP.print();
    }
}
