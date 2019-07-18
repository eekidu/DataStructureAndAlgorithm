package com.kee.leetcode.ploblems;

import com.kee.pojo.TreeNode;
import com.kee.util.TreeNodes;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num235 {

    /**
     * 方法一：递归
     * <p>
     * 从根节点开始遍历树
     * 如果节点 pp 和节点 qq 都在右子树上，那么以右孩子为根节点继续 1 的操作
     * 如果节点 pp 和节点 qq 都在左子树上，那么以左孩子为根节点继续 1 的操作
     * 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ansNode = root;
        while (ansNode != null) {
            if (p.val < ansNode.val && q.val < ansNode.val) {
                ansNode = ansNode.left;
            } else if (p.val > ansNode.val && q.val > ansNode.val) {
                ansNode = ansNode.right;
            } else {
              break;
            }
        }
        return ansNode;
    }


    public static void main(String[] args) {


        TreeNode root = TreeNodes.createTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNodes.printLevelThree(root);
        Num235 num235 = new Num235();
        TreeNode answNode = num235.lowestCommonAncestorV2(root, new TreeNode(2), new TreeNode(4));
        System.out.println(answNode.val);




    }
}
