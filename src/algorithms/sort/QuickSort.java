package algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序算法实现
 * <p>
 * 快速排序算法思想的适用场景：
 * 1. 数组中所有的元素都是提前确定的，且在算法执行过程中不会发生变化
 * 2. 每次划分都能将数组分为三部分：小于轴值的元素组成的子数组，轴值和大于轴值的元素组成的子数组
 */
public class QuickSort {

    private final Random random;

    public QuickSort() {
        random = new Random();
    }

    /**
     * 交换数组中的两个元素
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 划分函数：对l和r之间的元素划分成三部分：比轴值小的元素，轴值，比轴值大的元素，最后返回轴值所在位置
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] nums, int l, int r) {
        // 选取轴值元素：一般都是选择最后一个元素作为轴值
        int pivot = nums[r];
        // 轴值元素的位置
        int i = l - 1;
        // 将比轴值小的元素放到轴值的左边，比轴值大的元素放到轴值的右边
        // 循环结束后，轴值应该在的位置是 i + 1
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot) {
                // 比轴值小，则轴值位置右移
                swap(nums, ++i, j);
            }
        }
        // 交换轴值和轴值所在位置的元素
        swap(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 随机选择一个轴值
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int randomPartition(int[] nums, int l, int r) {
        int randomPivotIndex = random.nextInt(r - l) + l;
        swap(nums, randomPivotIndex, r);
        return partition(nums, l, r);
    }

    /**
     * 对nums数组中l和r之间的位置进行快速排序
     *
     * @param nums
     * @param l
     * @param r
     */
    public void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = randomPartition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        int[] sourceNums = Arrays.copyOfRange(nums, 0, nums.length);
        quickSort.sort(nums);
        System.out.println("数组" + Arrays.toString(sourceNums) + "快速排序后的结果为：" + Arrays.toString(nums));
    }
}
