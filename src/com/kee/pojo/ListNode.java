package com.kee.pojo;

/**
 * 单链表
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode listNode = this;
        while (listNode != null) {
            stringBuilder.append(listNode.val);
            if (listNode.next != null) {
                stringBuilder.append(" -> ");
            }
            listNode = listNode.next;
        }
        return stringBuilder.toString();
    }


}
