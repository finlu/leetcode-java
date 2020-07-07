package ds.stack.test;

import ds.stack.StackExample;
import utils.MatrixUtils;

public class TestStackExample {
    private static final StackExample stackExample = new StackExample();

    public static void testIsValid() {
        assert stackExample.isValid("()");
        assert stackExample.isValid("()[]{}");
        assert !stackExample.isValid("(]");
        assert !stackExample.isValid("([)]");
        System.out.println("Your code is AC!!!");
    }

    public static void testDecodeString() {
        String s = "3[a]2[bc]";
        System.out.println(s + "编码后的结果为：" + stackExample.decodeString(s));
    }

    public static void testUpdateMatrix() {
        int[][] matrix1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] matrix2 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        MatrixUtils.printMatrix(stackExample.updateMatrix(matrix1));
        MatrixUtils.printMatrix(stackExample.updateMatrix(matrix2));
    }

    public static void main(String[] args) {
//        testIsValid();
//        testDecodeString();
        testUpdateMatrix();
    }
}
