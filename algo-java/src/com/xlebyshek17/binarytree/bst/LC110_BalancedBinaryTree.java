package com.xlebyshek17.binarytree.bst;

import com.xlebyshek17.binarytree.TreeNode;

public class LC110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left_height = height(root.left);
        int right_height = height(root.right);

        if (Math.abs(left_height - right_height) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }
}
