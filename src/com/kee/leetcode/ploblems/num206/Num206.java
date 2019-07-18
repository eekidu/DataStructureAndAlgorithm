package com.kee.leetcode.ploblems.num206;

import com.kee.pojo.ListNode;

/**
 * 反转单链表
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 */
public class Num206 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 5; i++) {
            ListNode listNode = new ListNode(i);
            current.next = listNode;
            current = listNode;
        }

        System.out.println(head);
//        System.out.println(new Num206().reverseList(head));
        System.out.println(new Num206().reverseListV2(head));

    }


    /**
     * 反转一个单链表
     * 1.迭代：
     * <p>
     * 1->2->3->null
     * 3->2->1->null
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }


    /**
     * 2.递归
     * 1->2->3->null
     * 3->2->1->null
     *
     * @param node
     * @return
     */
    public ListNode reverseListV2(ListNode node) {
        //node == null 避免原始ListNode为空
        if (node == null || node.next == null) {
            return node;
        }

        ListNode p = reverseListV2(node.next);

        node.next.next = node;
        node.next = null;
        return p;
    }
}
