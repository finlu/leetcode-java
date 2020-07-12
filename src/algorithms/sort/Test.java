package algorithms.sort;

import java.util.*;

public class Test {
    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    private int partition(int[] input, int l, int r) {
        int x = input[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (input[j] <= x) {
                swap(input, ++i, j);
            }
        }
        swap(input, i + 1, r);
        return i + 1;
    }

    private void select(int[] input, int l, int r, int k) {
        int p = partition(input, l, r);
        if (p == k) {
            return;
        } else if (p > k) {
            select(input, l, p - 1, k);
        } else {
            select(input, p + 1, r, k);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 快速选择算法
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k == 0 || k > input.length) {
            return res;
        }
//        if (k > input.length) {
//            return (ArrayList<Integer>) Arrays.stream(input).boxed().collect(Collectors.toList());
//        }
        select(input, 0, input.length - 1, k - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10));
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 8));
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 7));
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 6));
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 5));
    }
}
