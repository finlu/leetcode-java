package ds.tree;

import java.util.*;

public class BinaryIndexTreeExample {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 对数组进行相对大小排序
        Set<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }

        // 构建相对位置排名表
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num: treeSet) {
            map.put(num, rank++);
        }

        // 使用树状数组计算前缀和
        BinaryIndexTree binaryIndexTree = new BinaryIndexTree(treeSet.size());
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = map.get(nums[i]);
            System.out.println("更新前");
            binaryIndexTree.print();
            binaryIndexTree.update(index, 1);
            System.out.println("在" + index + "处更新1后");
            binaryIndexTree.print();
            res.add(binaryIndexTree.query(index - 1));
        }
        Collections.reverse(res);
        return res;
    }
}
