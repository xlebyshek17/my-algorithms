package com.xlebyshek17.binarytree.dfs;

import com.xlebyshek17.binarytree.TreeNode;

public class LC104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
