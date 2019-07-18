package com.kee.util;

import com.kee.pojo.ListNode;

import java.util.Random;

public class ListNodes {

    /**
     * 生成指定长度的单链表
     *
     * @param size
     * @return
     */
    public static ListNode random(int size) {
        Random random = new Random();
        ListNode headListNode = null;
        ListNode tempListNode = null;
        for (int i = 0; i < size; i++) {
            ListNode listNode = new ListNode(random.nextInt(10));
            if (tempListNode != null) {
                tempListNode.next = listNode;
            } else {
                headListNode = listNode;
            }
            tempListNode = listNode;
        }
        return headListNode;
    }
}
