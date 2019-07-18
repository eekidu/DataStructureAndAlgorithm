package com.kee.util;

import com.kee.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNodes {
    /**
     * 生成指定层数的一颗满二叉树
     *
     * @param layer
     * @return
     */
    public static TreeNode fullTreeBylayer(int layer) {
        Random random = new Random();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        TreeNode rootNode = new TreeNode(random.nextInt(20));
        queue.add(rootNode);
        layer--;

        while (layer > 0) {
            //当前这一层的节点个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode leftNode = new TreeNode(random.nextInt(20));
                TreeNode rightNode = new TreeNode(random.nextInt(20));
                poll.left = leftNode;
                poll.right = rightNode;

                queue.add(leftNode);
                queue.add(rightNode);
            }
            layer--;
        }
        return rootNode;
    }

    public static TreeNode createTree(Integer[] src) {
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(src[index++]);
        queue.add(root);

        while (index < src.length) {
            TreeNode poll = queue.poll();
            Integer leftValue = src[index++];

            if (leftValue != null) {
                TreeNode leftNode = new TreeNode(leftValue);
                poll.left = leftNode;
                queue.add(leftNode);
            }

            Integer rightValue = src[index++];
            if (rightValue != null) {
                TreeNode rightNode = new TreeNode(rightValue);
                poll.right = rightNode;
                queue.add(rightNode);
            }
        }
        return root;
    }


    /**
     * 按层打印
     *
     * @param root
     */
    public static void printLevelThree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        //当前行的最右节点
        TreeNode lastNode = root;
        //下一行的最右节点
        TreeNode nLastNode = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currenNode = queue.poll();
            System.out.print(currenNode.val + " ");
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


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodes.fullTreeBylayer(5);
        printLevelThree(treeNode);
    }
}
