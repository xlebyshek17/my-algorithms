package com.xlebyshek17.binarytree.dfs;

import com.xlebyshek17.binarytree.TreeNode;

public class LC112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (targetSum == root.val && root.left == null && root.right == null) return true;

        int sum = targetSum - root.val;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
