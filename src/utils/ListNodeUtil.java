package utils;

import utils.ds.ListNode;

public class ListNodeUtil {
    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        return head.next;
    }

    public static void print(ListNode root) {
        while (root.next != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        if (root != null) {
            System.out.print(root.val);
        }
    }

    public static void println(ListNode root) {
        while (root.next != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        if (root != null) {
            System.out.println(root.val);
        }
    }
}