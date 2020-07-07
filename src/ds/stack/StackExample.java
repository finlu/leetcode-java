package ds.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackExample {
    /**
     * 有效的括号
     * https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/878/
     * 核心思想：左括号入栈，右括号遇到对应的左括号则左括号出栈，如果最后栈为空则说明匹配成功。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 字符串解码
     * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/890/
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                // 获取字母
                StringBuilder stringBuilder = new StringBuilder("");
                while (!stack.isEmpty() && stack.peek() != '[') {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();

                // 获取出现次数
                int base = 1;
                int value = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    value = (stack.pop() - '0') * base + value;
                    base *= 10;
                }

                // 构造新串
                stringBuilder = stringBuilder.reverse();
                for (int i = 0; i < value; i++) {
                    for (char c1 : stringBuilder.toString().toCharArray()) {
                        stack.push(c1);
                    }
                }

            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 多点BFS
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return matrix;
    }
}
