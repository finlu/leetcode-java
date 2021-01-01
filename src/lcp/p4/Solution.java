package lcp.p4;

import java.util.Arrays;

interface FindMedianSortedArraysInterface {
    double findMedianSortedArrays(int[] nums1, int[] nums2);
}

class Solution1 implements FindMedianSortedArraysInterface {

    /**
     * 寻找nums1和nums2中第k小的数
     * 
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 < pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex + 1) + getKthElement(nums1, nums2, midIndex2 + 1))
                    / 2.0;
            return median;

        }
    }
}

/**
 * 寻找两个有序数组的中位数:
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
 */
public class Solution {
    private static void testFindMedianSortedArrays(FindMedianSortedArraysInterface findMedianSortedArraysInterface) {
        long startTime = System.currentTimeMillis();
        int[][] nums1Arr = new int[][] { new int[] { 1, 3 }, new int[] { 1, 2 }, new int[] { 0, 0 }, new int[] {},
                new int[] { 2 } };
        int[][] nums2Arr = new int[][] { new int[] { 2 }, new int[] { 3, 4 }, new int[] { 0, 0 }, new int[] { 1 },
                new int[] {} };
        double[] medianArr = new double[] { 2, 2.5, 0.0, 1.0, 2.0 };
        for (int i = 0; i < medianArr.length; i++) {
            int[] nums1 = nums1Arr[i];
            int[] nums2 = nums2Arr[i];
            double pMedian = findMedianSortedArraysInterface.findMedianSortedArrays(nums1, nums2);
            System.out.println(Arrays.toString(nums1) + " " + Arrays.toString(nums2) + " ==> " + pMedian + " "
                    + (pMedian == medianArr[i]));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("cost: " + (endTime - startTime) + "s");
    }

    public static void main(String[] args) {
        FindMedianSortedArraysInterface findMedianSortedArraysInterface1 = new Solution1();
        testFindMedianSortedArrays(findMedianSortedArraysInterface1);
    }
}
