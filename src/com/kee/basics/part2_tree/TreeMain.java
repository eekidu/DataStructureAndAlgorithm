package com.kee.basics.part2_tree;

public class TreeMain {

//
//
//    public static void main(String[] args) {
////        mRootTreeNode.printInoderTree(mRootTreeNode);
////        System.out.println("---------");
////        mRootTreeNode.printPreoderTree(mRootTreeNode);
////        System.out.println("---------");
////        mRootTreeNode.printAftoderThree(mRootTreeNode);
////        System.out.println("---------");
//        mRootTreeNode.printLevelThree(mRootTreeNode);
//
//        TreeNode treeNode = flatten(mRootTreeNode);
//        mRootTreeNode.printLevelThree(treeNode);
//    }
//
//    /**
//     * 二叉树铺平
//     *
//     * @param root
//     */
//    public static TreeNode flatten(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        //用递归的思想，把左右先铺平
//        TreeNode left = flatten(root.left);
//        TreeNode right = flatten(root.right);
//        //把左指针和右指针先指向空。
//        root.left = null;
//        root.right = null;
//        //假如左子树生成的链表为空，那么忽略它，把右子树生成的链表指向根节点的右指针
//        if (left == null) {
//            root.right = right;
//            return root;
//        }
//        //如果左子树生成链表不为空，那么用while循环获取最后一个节点，并且它的右指针要指向右子树生成的链表的头节点
//        root.right = left;
//        TreeNode lastLeft = left;
//        while (lastLeft != null && lastLeft.right != null) {
//            lastLeft = lastLeft.right;
//        }
//        lastLeft.right = right;
//        return root;
//    }
//
//    /**
//     * 翻转二叉树
//     *
//     * @param root
//     * @return
//     */
//    public static TreeNode reverseBinaryTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        //把左子树翻转
//        TreeNode left = reverseBinaryTree(root.left);
//        //把右子树翻转
//        TreeNode right = reverseBinaryTree(root.right);
//        //把左右子树分别赋值给root节点，但是是翻转过来的顺序
//        root.left = right;
//        root.right = left;
//        return root;
//    }
}
