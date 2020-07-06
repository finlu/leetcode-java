package algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速选择算法可以用来高效地解决topK的问题
 */
public class QuickSelect {
    private final Random random;

    public QuickSelect() {
        random = new Random(666);
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
     * 随机选取一个值作为轴值
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
     * 根据轴值进行划分
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 快速选择算法实现，找出数组中第k小的值(位置为k-1)
     *
     * @param nums
     * @param l
     * @param r
     * @param k
     * @return
     */
    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int p = randomPartition(nums, l, r);
        if (p == k) {
            return nums[p];
        } else {
            return p < k ? quickSelect(nums, p + 1, r, k) : quickSelect(nums, l, p - 1, k);
        }
    }

    /**
     * 数组中第k小的数
     *
     * @param nums
     * @param k
     * @return
     */
    public int selectKSmallest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * 数组中第k大的数
     *
     * @param nums
     * @param k
     * @return
     */
    public int selectKLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 4;
        System.out.println(Arrays.toString(nums) + "中第" + k + "大的数为" + quickSelect.selectKLargest(nums, k));
        System.out.println(Arrays.toString(nums) + "中第" + k + "小的数为" + quickSelect.selectKSmallest(nums, k));
    }
}
