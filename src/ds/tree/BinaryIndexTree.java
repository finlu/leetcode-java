package ds.tree;

import java.util.Arrays;

/**
 * 树状数组实现
 */
public class BinaryIndexTree {
    private final int length;  // 树状数组的长度
    private final int[] data;  // 树状数组底层存储（从第1位开始存储）

    public BinaryIndexTree(int length) {
        this.length = length;
        this.data = new int[length + 1];
    }

    /**
     * lowbit操作实现，也可以写成 x & (~x + 1)
     *
     * @param x
     * @return
     */
    public int lowbit(int x) {
        return x & (-x);
    }

    /**
     * 向树状数组查询i之前的前缀和
     *
     * @param i
     * @return
     */
    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += this.data[i];
            i -= lowbit(i);
        }
        return res;
    }

    /**
     * 更新树状数组第i位的值
     *
     * @param i
     * @param delta
     */
    public void update(int i, int delta) {
        while (i <= this.length) {
            data[i] += delta;
            i += lowbit(i);
        }
    }

    /**
     * 输出树状数组的样子
     */
    public void print() {
        System.out.println(Arrays.toString(this.data));
    }
}
