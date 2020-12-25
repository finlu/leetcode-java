package lcp.p2;

import utils.ListNodeUtil;
import utils.ds.ListNode;

interface AddTwoNumbersInterface {
    ListNode addTwoNumbers(ListNode l1, ListNode l2);
}

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
 * 两数相加: https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution {
    private AddTwoNumbersInterface addTwoNumbersInterface;

    Solution(AddTwoNumbersInterface addTwoNumbersInterface) {
        this.addTwoNumbersInterface = addTwoNumbersInterface;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

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
        testTwoSum(addTwoNumbersInterface1);
    }
}
