package com.kee.leetcode.ploblems.num237;

import com.kee.pojo.ListNode;
import com.kee.util.ListNodes;

public class Num237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }

    public static void main(String[] args) {
        ListNode random = ListNodes.random(5);
        System.out.println(random.toString());

        Num237 num237=new Num237();
        num237.deleteNode(random.next);

        System.out.println(random.toString());

    }
}
