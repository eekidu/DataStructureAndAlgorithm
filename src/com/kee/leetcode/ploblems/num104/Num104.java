package com.kee.leetcode.ploblems.num104;

import com.kee.pojo.TreeNode;
import com.kee.util.TreeNodes;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/">题解</a>
 */
public class Num104 {

    /**
     * 递归，深度优先搜索（DFS）
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }


    /**
     * 迭代
     * 结点放入
     * @param root
     * @return
     */
    public int maxDepthV2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair<>(root, 1));
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode currentRoot = current.getKey();
            Integer currentDepth = current.getValue();
            if (currentRoot != null) {
                depth = Math.max(depth, currentDepth);
                queue.add(new Pair<>(currentRoot.left, currentDepth + 1));
                queue.add(new Pair<>(currentRoot.right, currentDepth + 1));
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        Num104 num104 = new Num104();
        TreeNode treeNode = TreeNodes.fullTreeBylayer(4);


        int depthV1 = num104.maxDepth(treeNode);
        int depthV2 = num104.maxDepthV2(treeNode);

        System.out.println(depthV1 + "  " + depthV2);

    }
}
