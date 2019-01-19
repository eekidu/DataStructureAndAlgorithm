package com.kee.basics.part2_tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kee on 2018/2/24.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    /**
     * 中序：左—根—右
     *
     * @param root
     */
    public void printInoderTree(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //递归调用printTree
        printInoderTree(root.left);
        System.out.println(root.val);
        printInoderTree(root.right);
    }

    /**
     * 前序:根—左—右
     *
     * @param root
     */
    public void printPreoderTree(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //递归调用printTree
        System.out.println(root.val);
        printPreoderTree(root.left);
        printPreoderTree(root.right);
    }

    /**
     * 后序：左—右—根
     *
     * @param root
     */
    public void printAftoderThree(TreeNode root) {
        if (root == null) {
            return;
        }
        printAftoderThree(root.left);
        printAftoderThree(root.right);
        System.out.println(root.val);
    }

    /**
     * 按层打印
     *
     * @param root
     */
    public void printLevelThree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        //当前行的最右节点
        TreeNode lastNode = root;
        //下一行的最有节点
        TreeNode nLastNode = root;
        queue.add(root);
        while (queue != null && queue.size() > 0) {
            TreeNode currenNode = queue.poll();
            System.out.print(currenNode.val);
            if (currenNode.left != null) {
                queue.add(currenNode.left);
                nLastNode = currenNode.left;
            }
            if (currenNode.right != null) {
                queue.add(currenNode.right);
                nLastNode = currenNode.right;
            }
            if (currenNode == lastNode) {
                System.out.println();
                lastNode = nLastNode;
            }
        }
    }
}
