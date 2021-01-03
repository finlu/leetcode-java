package lcp.p2;

import utils.ListNodeUtil;
import utils.ds.ListNode;

interface AddTwoNumbersInterface {
    ListNode addTwoNumbers(ListNode l1, ListNode l2);
}

/**
 * 经典归并思想合并链表
 */
class Solution1 implements AddTwoNumbersInterface {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int flag = 0;
        int addNum, res = 0;
        while (l1 != null && l2 != null) {
            addNum = l1.val + l2.val + flag;
            res = addNum % 10;
            flag = addNum / 10;
            cur.next = new ListNode(res);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            addNum = l1.val + flag;
            res = addNum % 10;
            flag = addNum / 10;
            cur.next = new ListNode(res);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            addNum = l2.val + flag;
            res = addNum % 10;
            flag = addNum / 10;
            cur.next = new ListNode(res);
            cur = cur.next;
            l2 = l2.next;
        }

        if (flag != 0) {
            cur.next = new ListNode(flag);
        }

        return head.next;
    }
}

/**
 * 使用归并的思想合并链表
 */
class Solution2 implements AddTwoNumbersInterface {

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            ListNode node = new ListNode(sum % 10);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 如果最高位存在进位，需要新建一个节点存储进位
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

/**
 * 两数相加: https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution {

    private static void testTwoSum(AddTwoNumbersInterface addTwoNumbersInterface) {
        long startTime = System.currentTimeMillis();
        ListNode l1 = ListNodeUtil.create(new int[] { 2, 4, 3 });
        ListNode l2 = ListNodeUtil.create(new int[] { 5, 6, 4 });
        ListNodeUtil.print(l1);
        System.out.print(" + ");
        ListNodeUtil.println(l2);
        ListNodeUtil.println(addTwoNumbersInterface.addTwoNumbers(l1, l2));
        long endTime = System.currentTimeMillis();
        System.out.println("cost: " + (endTime - startTime) + "s");
    }

    public static void main(String[] args) {
        AddTwoNumbersInterface addTwoNumbersInterface1 = new Solution1();
        AddTwoNumbersInterface addTwoNumbersInterface2 = new Solution2();
        testTwoSum(addTwoNumbersInterface1);
        testTwoSum(addTwoNumbersInterface2);
    }
}
