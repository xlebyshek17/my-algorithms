package com.xlebyshek17.binarytree.dfs;

import com.xlebyshek17.binarytree.TreeNode;

public class LC226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
