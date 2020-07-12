package custom.test_inner_ds;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 测试JDK内置类：TreeSet
 * TreeSet是一个有序集合，它继承于AbstractSet，并且实现了NavigableSet, Cloneable 和 Serializable 接口
 * TreeSet 实现了NavigableSet接口，意味着它支持一系列的导航方法。比如查找与指定目标最匹配项。
 * TreeSet 实现了Cloneable接口，意味着它能被克隆。
 * TreeSet 实现了java.io.Serializable接口，意味着它支持序列化。
 * TreeSet是基于TreeMap实现的。TreeSet中的元素支持2种排序方式：自然排序 或者 根据创建TreeSet 时提供的 Comparator 进行排序。这取决于使用的构造方法。
 * TreeSet为基本操作（add、remove 和 contains）提供受保证的 log(n) 时间开销。
 * 另外，TreeSet是非同步的。 它的 iterator 方法返回的迭代器是fail-fast的。
 */
public class TestTreeSet {
    // 顺序遍历TreeSet
    public static void ascIteratorThroughIterator(Set<Integer> set) {
        System.out.println("---- Ascend Iterator ----");
        for (Integer integer : set) {
            System.out.println("asc: " + integer);
        }
    }

    // 逆序遍历TreeSet
    public static void descIteratorThroughIterator(NavigableSet<Integer> set) {
        System.out.println("---- Descend Iterator ----");
        for (Iterator<Integer> iter = set.descendingIterator(); iter.hasNext(); )
            System.out.println("desc: " + iter.next());
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(4);
        ascIteratorThroughIterator(treeSet);
        descIteratorThroughIterator(treeSet);
    }
}
