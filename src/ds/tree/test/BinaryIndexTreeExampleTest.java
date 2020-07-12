package ds.tree.test;

import ds.tree.BinaryIndexTreeExample;

import java.util.Arrays;

public class BinaryIndexTreeExampleTest {
    private static final BinaryIndexTreeExample binaryIndexTreeExample = new BinaryIndexTreeExample();

    public static void testCountSmaller() {
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(Arrays.toString(binaryIndexTreeExample.countSmaller(nums).toArray()));
    }

    public static void main(String[] args) {
        testCountSmaller();
    }
}
